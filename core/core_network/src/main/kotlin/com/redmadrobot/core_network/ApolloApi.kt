package com.redmadrobot.core_network

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Mutation
import com.apollographql.apollo.api.Operation
import com.apollographql.apollo.api.Operation.Variables
import com.apollographql.apollo.api.Query
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.coroutines.toDeferred
import com.redmadrobot.core_network.exception.NetworkExceptionHandler
import com.redmadrobot.core_network.exception.ServerException
import com.redmadrobot.core_network.exception.ServerExceptionFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

open class ApolloApi(
    private val apolloClient: ApolloClient,
    private val networkErrorHandler: NetworkExceptionHandler
) {

    suspend fun <D : Operation.Data, T, V : Variables> query(query: Query<D, T, V>): T {
        val response = queryForRawResponse(query)
        return response.data ?: throw getServerException(response)
    }

    suspend fun <D : Operation.Data, T, V : Variables> mutate(mutation: Mutation<D, T, V>): T {
        val response = mutateForRawResponse(mutation)
        return response.data ?: throw getServerException(response)
    }

    suspend fun <D : Operation.Data, T, V : Variables> mutateForRawResponse(mutation: Mutation<D, T, V>): Response<T> {
        return withContext(Dispatchers.IO) {
            val response: Response<T>?
            try {
                response = apolloClient.mutate(mutation).toDeferred().await()
            } catch (exception: Throwable) {
                throw networkErrorHandler.handle(exception)
            }
            response
        }
    }

    suspend fun <D : Operation.Data, T, V : Variables> queryForRawResponse(query: Query<D, T, V>): Response<T> {
        return withContext(Dispatchers.IO) {
            val response: Response<T>?
            try {
                response = apolloClient.query(query).toDeferred().await()
            } catch (exception: Throwable) {
                throw networkErrorHandler.handle(exception)
            }
            response
        }
    }

    private fun <T> getServerException(response: Response<T>): ServerException {
        return ServerExceptionFactory.createException(checkNotNull(response.errors))
    }
}
