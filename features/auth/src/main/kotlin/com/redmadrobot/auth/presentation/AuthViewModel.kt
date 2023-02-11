package com.redmadrobot.auth.presentation

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.redmadrobot.core.extensions.safeLaunch
import com.redmadrobot.core_navigation.navigation.Router
import com.redmadrobot.core_navigation.navigation.screens.Routes
import com.redmadrobot.core_network.ApolloApi
import com.redmadrobot.core_network.LoginMutation
import com.redmadrobot.core_presentation.extensions.update
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val api: ApolloApi,
    private val router: Router,
    private val context: Application,
) : ViewModel() {

    private val _viewState = MutableStateFlow(AuthState(isLoading = false))
    val viewState: StateFlow<AuthState> = _viewState

    fun onLoginClicked() {
        _viewState.update { copy(isLoading = true) }
        viewModelScope.safeLaunch(
            {
                api.mutate(LoginMutation("robot@redmadrobot.com", "Qq!11111"))
                router.navigate(Routes.Home)
            },
            onError = { throwable ->
                Toast.makeText(context, throwable.localizedMessage, Toast.LENGTH_LONG).show()
            }
        )
    }
}