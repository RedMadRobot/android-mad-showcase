package com.redmadrobot.mad

import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.redmadrobot.core_presentation.navigation.Router

class AppRouter : Router {

    private lateinit var navController: NavController

    fun initNavController(navController: NavController) {
        this.navController = navController
    }

    override fun navigate(route: String) {
        navController.navigate(route)
    }
}