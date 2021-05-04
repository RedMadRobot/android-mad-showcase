package com.redmadrobot.mad

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltNavGraphViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.redmadrobot.auth.presentation.AuthScreen
import com.redmadrobot.core_navigation.navigation.composableScreen
import com.redmadrobot.core_navigation.navigation.screens.Screens
import com.redmadrobot.home.presentation.HomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val router: AppRouter
        get() = (application as MADApp).appRouter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { Content() }
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
        }
    }
}
