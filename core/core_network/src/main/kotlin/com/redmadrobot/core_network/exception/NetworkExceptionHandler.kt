package com.redmadrobot.core_network.exception

import android.content.Context
import com.apollographql.apollo.exception.ApolloNetworkException
import com.redmadrobot.core_network.R
import java.net.*

class NetworkExceptionHandler constructor(private val context: Context) {

    fun handle(exception: Throwable): NetworkException {
        val message: String = if (exception is ApolloNetworkException &&
            exception.cause.isNetworkException()
        ) {
            context.getString(R.string.error_no_internet)
        } else context.getString(R.string.error_network_unknown)

        return NetworkException(message)
    }

    private fun Throwable?.isNetworkException(): Boolean {
        return when (this) {
            is ConnectException,
            is SocketException,
            is SocketTimeoutException,
            is UnknownHostException,
            is ProtocolException -> true
            else -> false
        }
    }
}
