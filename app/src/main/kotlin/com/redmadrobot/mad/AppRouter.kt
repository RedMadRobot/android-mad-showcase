package com.redmadrobot.mad

import androidx.navigation.NavController
import com.redmadrobot.core_navigation.navigation.Router
import com.redmadrobot.core_navigation.navigation.Route

class AppRouter : Router {

    private lateinit var navController: NavController

    fun init(navController: NavController) {
        this.navController = navController
    }

    override fun navigate(route: Route) {
        navController.navigate(route.name)
    }
}
