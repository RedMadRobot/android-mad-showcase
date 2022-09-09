package com.redmadrobot.auth.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.redmadrobot.auth.R

@Composable
fun AuthScreen(viewModel: AuthViewModel) {
    val isLoading = viewModel.viewState.collectAsState().value.isLoading
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.login_title),
            color = Color.White,
            modifier = Modifier.padding(bottom = 12.dp)
        )
        if (isLoading) {
            CircularProgressIndicator()
        } else {
            Button(onClick = viewModel::onLoginClicked) {
                Text(stringResource(id = R.string.login_button_title))
            }
        }
    }
}