package com.redmadrobot.mad

import androidx.navigation.NavController
import com.redmadrobot.core_navigation.navigation.Router
import com.redmadrobot.core_navigation.navigation.Screen

class AppRouter : Router {

    private lateinit var navController: NavController

    fun init(navController: NavController) {
        this.navController = navController
    }

    override fun navigate(screen: Screen) {
        navController.navigate(screen.name)
    }
}
