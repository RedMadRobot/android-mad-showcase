package com.redmadrobot.core_presentation.navigation

import androidx.navigation.NavController

interface RouterProvider {

    fun initNavController(navController: NavController)

    fun provideRouter(): Router
}