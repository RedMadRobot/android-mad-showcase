package com.redmadrobot.mad.di.modules

import android.app.Application
import com.redmadrobot.core_presentation.navigation.Router
import com.redmadrobot.core_presentation.navigation.RouterProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideRouter(app: Application): Router {
        return (app as RouterProvider).provideRouter()
    }
}