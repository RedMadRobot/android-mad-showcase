package com.redmadrobot.auth.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.redmadrobot.auth.R

@Composable
fun AuthRoute(viewModel: AuthViewModel = hiltViewModel()) {
    val isLoading = viewModel.viewState.collectAsStateWithLifecycle().value.isLoading
    AuthScreen(
        isLoading,
        viewModel::onLoginClicked
    )
}

@Composable
fun AuthScreen(
    isLoading: Boolean,
    onLoginClicked: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.login_title),
            color = Color.White,
            modifier = Modifier.padding(bottom = 4.dp),
        )
        if (isLoading) {
            CircularProgressIndicator()
        } else {
            Button(onClick = onLoginClicked) {
                Text(stringResource(id = R.string.login_button_title))
            }
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0x434A74
)
@Composable
fun PreviewAuthScreen() {
    return AuthScreen(isLoading = false) {}
}