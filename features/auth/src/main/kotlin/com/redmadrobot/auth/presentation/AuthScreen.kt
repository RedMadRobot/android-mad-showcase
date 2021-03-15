package com.redmadrobot.auth.presentation

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.navigate

@Composable
fun AuthScreen(
    viewModel: AuthViewModel,
    navController: NavController,
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text("Please login", color = Color.White)
        Button(onClick = { navController.navigate("home") }) {
            Text("Login", color = Color.White)
        }
    }
}