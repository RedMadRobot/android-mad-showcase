package com.redmadrobot.mad.feature_example_navigation.screens

import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomNavigation
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.redmadrobot.mad.core.navigation.BackStack
import com.redmadrobot.mad.core.navigation.Router
import com.redmadrobot.mad.feature_example_navigation.screens.TabRoute.TabA
import com.redmadrobot.mad.feature_example_navigation.screens.TabRoute.TabB
import com.redmadrobot.mad.feature_example_navigation.screens.TabRoute.TabC

@Composable
fun BottomTabsScreen() {
    Router<TabRoute>("Tab", start = TabA) {
        Column {
            Box(modifier = Modifier.weight(1f)) {
                when (it.data) {
                    TabA -> SampleScreenRouter("A")
                    TabB -> SampleScreenRouter("B")
                    TabC -> SampleScreenRouter("C")
                }
            }

            BottomNavigation {
                TabButton(backStack = this@Router, tabRoute = TabA, currentTabRoute = it.data)
                TabButton(backStack = this@Router, tabRoute = TabB, currentTabRoute = it.data)
                TabButton(backStack = this@Router, tabRoute = TabC, currentTabRoute = it.data)
            }
        }
    }
}

@Composable
fun RowScope.TabButton(backStack: BackStack<TabRoute>, tabRoute: TabRoute, currentTabRoute: TabRoute) {
    val isSelected = currentTabRoute == tabRoute
    Box(modifier = Modifier.weight(1f).background(Color.Gray.copy(alpha = if (isSelected) 1f else 0.3f))) {
        Box(Modifier.fillMaxSize().clickable(onClick = { backStack.replace(tabRoute) })) {
            Text(
                text = tabRoute.toString(),
                style = MaterialTheme.typography.h5
            )
        }
    }
}

sealed class TabRoute {
    object TabA : TabRoute() {
        override fun toString(): String = "A"
    }

    object TabB : TabRoute() {
        override fun toString(): String = "B"
    }

    object TabC : TabRoute() {
        override fun toString(): String = "C"
    }
}