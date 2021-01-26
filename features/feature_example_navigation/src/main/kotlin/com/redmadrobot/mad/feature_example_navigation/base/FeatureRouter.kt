package com.redmadrobot.mad.feature_example_navigation.base

import androidx.compose.runtime.Composable
import com.redmadrobot.mad.core.navigation.Router
import com.redmadrobot.mad.feature_example_navigation.HomeScreen
import com.redmadrobot.mad.feature_example_navigation.MultipleStartScreen
import com.redmadrobot.mad.feature_example_navigation.screens.SimpleScreen
import com.redmadrobot.mad.feature_example_navigation.screens.SplitScreen
import com.redmadrobot.mad.feature_example_navigation.screens.BottomTabsScreen
import com.redmadrobot.mad.feature_example_navigation.screens.ComplexScreen
import com.redmadrobot.mad.feature_example_navigation.screens.ResultExampleScreen
import com.redmadrobot.mad.feature_example_navigation.screens.TranslucentScreen

@Composable
fun FeatureRouter() {
    return Router<FeatureRoute>("Root", FeatureRoute.HomeRoute) {
        when (it.data) {
            FeatureRoute.HomeRoute -> HomeScreen { appRoute -> push(appRoute) }
            FeatureRoute.SimpleRoute -> SimpleScreen()
            FeatureRoute.MultipleStartRoute -> MultipleStartScreen()
            FeatureRoute.BottomTabsRoute -> BottomTabsScreen()
            FeatureRoute.SplitScreenRoute -> SplitScreen()
            FeatureRoute.ComplexRoute -> ComplexScreen()
            FeatureRoute.TranslucentRoute -> TranslucentScreen()
            FeatureRoute.ResultRoute -> ResultExampleScreen()
        }
    }
}