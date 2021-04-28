package com.redmadrobot.mad

import android.app.Application
import androidx.navigation.NavController
import com.redmadrobot.core_presentation.navigation.RouterProvider
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MADApp : Application(), RouterProvider {

    private val appRouter = AppRouter()

    override fun initNavController(navController: NavController) {
        appRouter.initNavController(navController)
    }

    override fun provideRouter() = appRouter
}