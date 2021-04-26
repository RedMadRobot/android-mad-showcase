package com.redmadrobot.core.extensions

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Suppress("InstanceOfCheckForException")
fun CoroutineScope.safeLaunch(
    block: suspend CoroutineScope.() -> Unit,
    onError: (Throwable) -> Unit
) {
    launch {
        try {
            block.invoke(this)
        } catch (exception: Exception) {
            if (exception !is CancellationException) {
                onError.invoke(exception)
            }
        }
    }
}