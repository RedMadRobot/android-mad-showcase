package com.redmadrobot.core_navigation.navigation.screens

import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.redmadrobot.core_navigation.navigation.Route

object Routes {
    private const val KEY = "id"
    val Auth = Route(name = "Auth")
    val Home = Route(name = "Home")
    val Details = Route(name = "Details/{$KEY}")

    fun toDetails(id: String? = null): Route {
        val arguments = listOf(
            navArgument(KEY) { type = NavType.StringType }
        )
        return Route(name = "Details/$id", arguments = arguments)
    }
}