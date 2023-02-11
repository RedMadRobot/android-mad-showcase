package com.redmadrobot.mad

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.redmadrobot.auth.presentation.AuthRoute
import com.redmadrobot.core_navigation.navigation.composableScreen
import com.redmadrobot.core_navigation.navigation.screens.Routes
import com.redmadrobot.details.presentation.DetailsRoute
import com.redmadrobot.home.presentation.HomeRoute
import com.redmadrobot.home.presentation.HomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@ExperimentalComposeUiApi
class MainActivity : AppCompatActivity() {

    private val router: AppRouter
        get() = (application as MADApp).appRouter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Content()
        }
    }

    @Composable
    fun Content() {
        val navController = rememberNavController()
        router.init(navController)
        NavHost(navController, startDestination = Routes.Auth.name) {
            composableScreen(Routes.Auth) {
                AuthRoute()
            }
            composableScreen(Routes.Home) {
                HomeRoute()
            }
            composableScreen(Routes.Details) {
                DetailsRoute()
            }
        }
    }
}
