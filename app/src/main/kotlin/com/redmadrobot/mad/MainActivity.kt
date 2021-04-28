package com.redmadrobot.mad

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltNavGraphViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.redmadrobot.auth.presentation.AuthScreen
import com.redmadrobot.core_presentation.navigation.RouterProvider
import com.redmadrobot.core_presentation.navigation.Screens
import com.redmadrobot.home.presentation.HomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { Content { (application as RouterProvider).initNavController(navController = it) } }
    }

    @Preview
    @Composable
    fun Content(
        onNavControllerInit: (NavController) -> Unit,
    ) {
        val navController = rememberNavController()
        onNavControllerInit(navController)
        val startRoute = Screens.AUTH
        NavHost(navController, startDestination = startRoute) {
            composable(Screens.AUTH) {
                AuthScreen(hiltNavGraphViewModel())
            }
            composable(Screens.HOME) {
                HomeScreen(hiltNavGraphViewModel())
            }
        }
    }
}
