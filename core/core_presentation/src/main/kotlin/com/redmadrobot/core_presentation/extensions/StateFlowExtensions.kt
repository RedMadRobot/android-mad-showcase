package com.redmadrobot.core_presentation.extensions

import kotlinx.coroutines.flow.MutableStateFlow

fun <T> MutableStateFlow<T>.requireValue(
    messageIfNull: String = "required value was null and not set"
): T {
    return this.value ?: error(messageIfNull)
}

inline fun <reified T : Any> MutableStateFlow<T>.update(action: T.() -> T) {
    value = action.invoke(requireValue())
}
