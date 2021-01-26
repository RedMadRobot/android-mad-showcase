package com.redmadrobot.mad.core.navigation

import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Providers
import androidx.compose.runtime.ambientOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.onActive
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.AmbientContext

internal val AmbientNullableBackStack = ambientOf<BackStack<Any>?> { null }
val AmbientBackStack = ambientOf<BackStack<Any>> { throw IllegalStateException("Missing Router(...) { ... } above") }

@Composable
inline fun <reified T : Any> Router(start: T, otherStart: List<T> = emptyList(), noinline children: @Composable BackStack<T>.(Route<T>) -> Unit) =
    Router(T::class.java.name, start, otherStart, children)

@Composable
fun <T : Any> Router(id: BackStackId, start: T, otherStart: List<T> = emptyList(), children: @Composable BackStack<T>.(Route<T>) -> Unit) {
    val activity = AmbientContext.current as? ComponentActivity
    val parentKey = AmbientNullableBackStack.current?.key
    val backStack = remember { backStackController.register(id, parentKey, start, otherStart) }
    var showRoutesState by remember { mutableStateOf(backStack.currentWithShowStack) }

    onActive {
        val onBackPressCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                backStackController.pop()
            }
        }
        activity?.onBackPressedDispatcher?.addCallback(onBackPressCallback)

        backStackController.addListener(object : BackStackController.Listener {
            override fun onBackStackChanged(snapshot: List<GlobalRoute>) {
                onBackPressCallback.isEnabled = snapshot.size > 1
            }
        })

        val listener = object : BackStack.Listener<T> {
            override fun onCurrentChanged(route: Route<T>) {
                showRoutesState = backStack.currentWithShowStack
            }
        }
        backStack.addListener(listener)

        onDispose {
            backStack.removeListener(listener)
            onBackPressCallback.remove()
        }
    }

    @Suppress("UNCHECKED_CAST") val anyBackStack = backStack as BackStack<Any>
    Providers(AmbientBackStack.provides(anyBackStack), AmbientNullableBackStack.provides(anyBackStack)) {
        Box(modifier = Modifier) {
            showRoutesState.forEach { children(backStack, it) }
        }
    }
}