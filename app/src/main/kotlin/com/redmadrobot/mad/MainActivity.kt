package com.redmadrobot.mad

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltNavGraphViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.redmadrobot.auth.presentation.AuthScreen
import com.redmadrobot.core_navigation.navigation.composableScreen
import com.redmadrobot.core_navigation.navigation.screens.Screens
import com.redmadrobot.details.presentation.DetailsScreen
import com.redmadrobot.home.presentation.HomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val router: AppRouter
        get() = (application as MADApp).appRouter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                Content()
            }
        }
    }

    @Composable
    fun Content() {
        val navController = rememberNavController()
        router.init(navController)
        NavHost(navController, startDestination = Screens.Auth.name) {
            composableScreen(Screens.Auth) {
                AuthScreen(hiltNavGraphViewModel())
            }
            composableScreen(Screens.Home) {
                HomeScreen(hiltNavGraphViewModel())
            }
            composableScreen(Screens.Details) {
                DetailsScreen(hiltNavGraphViewModel())
            }
        }
    }
}
