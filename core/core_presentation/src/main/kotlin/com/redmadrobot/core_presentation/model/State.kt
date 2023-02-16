package com.redmadrobot.core_presentation.model

sealed class State<T>

data class Content<T>(val content: T) : State<T>()
class Loading<T> : State<T>()
class Stub<T>(val error: Throwable) : State<T>()
