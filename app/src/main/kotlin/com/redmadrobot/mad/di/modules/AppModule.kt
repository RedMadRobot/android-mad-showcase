package com.redmadrobot.mad.di.modules

import android.app.Application
import com.redmadrobot.core_navigation.navigation.Router
import com.redmadrobot.mad.MADApp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideRouter(app: Application): Router {
        return (app as MADApp).appRouter
    }
}