package com.redmadrobot.mad

import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.ScrollableRow
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.onActive
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.redmadrobot.mad.AppRoute.*
import com.redmadrobot.mad.AppRoute.ComplexRoute
import com.redmadrobot.mad.AppRoute.TranslucentRoute
import com.redmadrobot.mad.core.navigation.*
import com.redmadrobot.mad.examples.*

@Composable
fun MadApp() {
    Column {
        BackStackVisualizer()
        Router<AppRoute>("Root", HomeRoute) {
            when (it.data) {
                HomeRoute -> HomeScreen { appRoute -> push(appRoute) }
                SimpleRoute -> SimpleScreen()
                MultipleStartRoute -> MultipleStartScreen()
                BottomTabsRoute -> BottomTabsScreen()
                SplitScreenRoute -> SplitScreen()
                ComplexRoute -> ComplexScreen()
                TranslucentRoute -> TranslucentScreen()
                ResultRoute -> ResultExampleScreen()
            }
        }
    }
}

@Composable
fun BackStackVisualizer() {
    val globalRoutes = remember { mutableStateOf(backStackController.snapshot) }
    onActive {
        val listener = object : BackStackController.Listener {
            override fun onBackStackChanged(snapshot: List<GlobalRoute>) {
                globalRoutes.value = snapshot
            }
        }
        backStackController.addListener(listener)
        onDispose {
            backStackController.removeListener(listener)
        }
    }

    Box(modifier = Modifier.height(144.dp)) {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.primary) {
            ScrollableColumn(modifier = Modifier.fillMaxSize(), content = {
                ScrollableRow(modifier = Modifier.fillMaxSize(), content = {
                    Text(
                        modifier = Modifier.fillMaxSize(),
                        text = buildBackStackVisual(globalRoutes.value),
                        style = TextStyle(fontFamily = FontFamily.Monospace, fontSize = 12.sp)
                    )
                })

            })

        }
    }
}

private fun buildBackStackVisual(globalRoutes: List<GlobalRoute>): String {
    return globalRoutes
        .map { globalRoute ->
            globalRoute.snapshot.filter { it.key.id != "Root" }.sortedBy { it.key.parentCount }
                .map { it.name }
        }
        .reversed()
        .filter { it.isNotEmpty() }
        .joinToString(separator = "\n")
}

private val Route<*>.name: String get() = "${this.key.id}${this.data}"
