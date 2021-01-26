package com.redmadrobot.mad.feature_example_navigation

import androidx.compose.runtime.Composable
import com.redmadrobot.mad.feature_example_navigation.screens.SampleRoute
import com.redmadrobot.mad.feature_example_navigation.screens.SampleScreenRouter

@Composable
fun MultipleStartScreen() {
    SampleScreenRouter(
        "A",
        listOf(
            SampleRoute(10),
            SampleRoute(20)
        )
    )
}
