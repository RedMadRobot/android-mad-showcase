package com.redmadrobot.core_network.exception

import com.apollographql.apollo.api.Error

object ServerExceptionFactory {

    private const val EXTENSIONS = "extensions"
    private const val TYPE = "type"

    fun createException(errors: List<Error>): ServerException {
        val error = errors.first()
        val message = error.message
        val extensions = error.customAttributes[EXTENSIONS] as? HashMap<*, *>
        val errorType = extensions?.let { it[TYPE] as? String }.orEmpty()
        return getException(message, errorType)
    }

    @Suppress("UseIfInsteadOfWhen")
    private fun getException(message: String, errorType: String): ServerException {
        return when (errorType) {
            "" -> UnknownTypeServerException(message)
            else -> ServerException(message)
        }
    }
}

class UnknownTypeServerException(message: String) : ServerException(message)
