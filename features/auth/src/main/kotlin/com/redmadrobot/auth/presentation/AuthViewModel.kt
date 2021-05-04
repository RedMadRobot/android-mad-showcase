package com.redmadrobot.auth.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.redmadrobot.core.extensions.safeLaunch
import com.redmadrobot.core_navigation.navigation.Router
import com.redmadrobot.core_navigation.navigation.screens.Screens
import com.redmadrobot.core_network.ApolloApi
import com.redmadrobot.core_network.LoginMutation
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val api: ApolloApi,
    private val router: Router,
) : ViewModel() {

    fun onLoginClicked() {
        viewModelScope.safeLaunch(
            {
                api.mutate(LoginMutation("robot@redmadrobot.com", "Qq!11111"))
                router.navigate(Screens.Home)
            },
            onError = { throwable ->
            }
        )
    }
}