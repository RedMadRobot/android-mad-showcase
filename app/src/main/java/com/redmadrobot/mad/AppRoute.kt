package com.redmadrobot.mad

sealed class AppRoute {
    object HomeRoute : AppRoute() {
        override fun toString(): String = "Home"
    }

    object SimpleRoute : AppRoute() {
        override fun toString(): String = "Simple"
    }

    object MultipleStartRoute : AppRoute() {
        override fun toString(): String = "Multiple start routes"
    }

    object BottomTabsRoute : AppRoute() {
        override fun toString(): String = "Bottom tabs"
    }

    object SplitScreenRoute : AppRoute() {
        override fun toString(): String = "Split screen"
    }

    object ComplexRoute : AppRoute() {
        override fun toString(): String = "Complex"
    }

    object TranslucentRoute : AppRoute() {
        override fun toString(): String = "Translucent"
    }

    object ResultRoute : AppRoute() {
        override fun toString(): String = "Result"
    }
}