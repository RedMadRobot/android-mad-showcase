package com.redmadrobot.auth.presentation

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import com.redmadrobot.auth.R

@Composable
fun AuthScreen(viewModel: AuthViewModel) {
    val isLoading = viewModel.viewState.collectAsState().value.isLoading
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(stringResource(id = R.string.login_title))
        if (isLoading) {
            CircularProgressIndicator()
        } else {
            Button(onClick = viewModel::onLoginClicked) {
                Text(stringResource(id = R.string.login_button_title))
            }
        }
    }
}