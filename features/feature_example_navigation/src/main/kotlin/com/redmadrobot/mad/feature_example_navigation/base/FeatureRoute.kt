package com.redmadrobot.mad.feature_example_navigation.base

sealed class FeatureRoute {
    object HomeRoute : FeatureRoute() {
        override fun toString(): String = "Home"
    }

    object SimpleRoute : FeatureRoute() {
        override fun toString(): String = "Simple"
    }

    object MultipleStartRoute : FeatureRoute() {
        override fun toString(): String = "Multiple start routes"
    }

    object BottomTabsRoute : FeatureRoute() {
        override fun toString(): String = "Bottom tabs"
    }

    object SplitScreenRoute : FeatureRoute() {
        override fun toString(): String = "Split screen"
    }

    object ComplexRoute : FeatureRoute() {
        override fun toString(): String = "Complex"
    }

    object TranslucentRoute : FeatureRoute() {
        override fun toString(): String = "Translucent"
    }

    object ResultRoute : FeatureRoute() {
        override fun toString(): String = "Result"
    }
}