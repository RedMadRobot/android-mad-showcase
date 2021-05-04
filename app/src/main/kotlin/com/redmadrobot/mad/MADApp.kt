package com.redmadrobot.mad

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MADApp : Application() {

    val appRouter = AppRouter()
}