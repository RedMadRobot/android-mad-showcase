package com.redmadrobot.core_navigation.navigation.screens

import androidx.navigation.NavType
import androidx.navigation.compose.navArgument
import com.redmadrobot.core_navigation.navigation.Screen

object Screens {
    private const val KEY = "id"
    val Auth = Screen(name = "Auth")
    val Home = Screen(name = "Home")
    val Details = Screen(name = "Details/{$KEY}")

    fun toDetails(id: String? = null): Screen {
        val arguments = listOf(
            navArgument(KEY) { type = NavType.StringType }
        )
        return Screen(name = "Details/$id", arguments = arguments)
    }
}