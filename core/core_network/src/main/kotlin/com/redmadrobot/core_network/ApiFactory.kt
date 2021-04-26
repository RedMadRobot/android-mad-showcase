package com.redmadrobot.core_network

import com.apollographql.apollo.ApolloClient
import com.redmadrobot.core_network.exception.NetworkExceptionHandler
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

object ApiFactory {

    private const val DEFAULT_SERVER = "https://mad-showcase-fake-server.herokuapp.com/graphql"

    fun provideApi(networkExceptionHandler: NetworkExceptionHandler): ApolloApi {
        val okhttpClient = provideOkHttpClient()
        val apolloClient = provideApolloClient(okhttpClient)
        return ApolloApi(apolloClient, networkExceptionHandler)
    }

    private fun provideApolloClient(
        okHttpClient: OkHttpClient,
    ): ApolloClient {
        return ApolloClient.builder()
            .serverUrl(DEFAULT_SERVER)
            .okHttpClient(okHttpClient)
            .build()
    }

    private fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(NetworkConstants.CONNECT_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .readTimeout(NetworkConstants.READ_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .writeTimeout(NetworkConstants.WRITE_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .build()
    }
}