package com.redmadrobot.core_navigation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NamedNavArgument
import androidx.navigation.compose.composable

data class Screen(
    val name: String,
    val arguments: List<NamedNavArgument> = emptyList(),
)

fun NavGraphBuilder.composableScreen(
    screen: Screen,
    content: @Composable (NavBackStackEntry) -> Unit
): Unit = composable(
    route = screen.name,
    arguments = screen.arguments,
    content = content,
)