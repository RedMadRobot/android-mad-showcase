package com.redmadrobot.mad

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltNavGraphViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.redmadrobot.auth.presentation.AuthScreen
import com.redmadrobot.home.presentation.HomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { Content() }
    }

    @Preview
    @Composable
    fun Content() {
        val navController = rememberNavController()
        val startRoute = "auth"
        NavHost(navController, startDestination = startRoute) {
            composable("auth") {
                AuthScreen(hiltNavGraphViewModel(), navController)
            }
            composable("home") {
                HomeScreen(hiltNavGraphViewModel())
            }
        }
    }
}
