package com.redmadrobot.auth.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.redmadrobot.core.extensions.safeLaunch
import com.redmadrobot.core_network.ApolloApi
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val api: ApolloApi
) : ViewModel() {

    private fun onLoginClicked() {
        viewModelScope.safeLaunch(
            {

            },
            onError = { throwable ->
            }
        )
    }
}