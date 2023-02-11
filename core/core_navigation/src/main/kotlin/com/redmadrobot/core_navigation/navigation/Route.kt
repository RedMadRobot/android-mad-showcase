package com.redmadrobot.core_navigation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

data class Route(
    val name: String,
    val arguments: List<NamedNavArgument> = emptyList(),
)

fun NavGraphBuilder.composableScreen(
    route: Route,
    content: @Composable (NavBackStackEntry) -> Unit
): Unit = composable(
    route = route.name,
    arguments = route.arguments,
    content = content,
)