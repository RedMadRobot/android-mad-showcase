package com.redmadrobot.mad.feature_example_navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.ui.tooling.preview.Preview
import com.redmadrobot.mad.feature_example_navigation.base.FeatureRouter
import com.redmadrobot.mad.feature_example_navigation.debug.BackStackVisualizer


@Preview
@Composable
fun FeatureExampleNavigation() {
    Column {
        BackStackVisualizer()
        FeatureRouter()
    }
}