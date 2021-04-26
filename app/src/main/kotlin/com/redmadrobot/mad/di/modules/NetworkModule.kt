package com.redmadrobot.mad.di.modules

import android.content.Context
import com.redmadrobot.core_network.ApiFactory
import com.redmadrobot.core_network.ApolloApi
import com.redmadrobot.core_network.exception.NetworkExceptionHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideApi(networkExceptionHandler: NetworkExceptionHandler): ApolloApi {
        return ApiFactory.provideApi(networkExceptionHandler)
    }

    @Provides
    fun provideNetworkExceptionHandler(@ApplicationContext context: Context): NetworkExceptionHandler {
        return NetworkExceptionHandler(context)
    }
}