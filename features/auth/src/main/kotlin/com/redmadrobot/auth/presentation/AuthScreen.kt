package com.redmadrobot.auth.presentation

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color

@Composable
fun AuthScreen(viewModel: AuthViewModel) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text("Please login", color = Color.White)
        Button(onClick = { viewModel.onLoginClicked() }) {
            Text("Login", color = Color.White)
        }
    }
}