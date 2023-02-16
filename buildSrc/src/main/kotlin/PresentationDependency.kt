object PresentationVersions {
    const val APPCOMPAT = "1.6.1"

    const val COMPOSE = "1.3.3"

    const val COMPOSE_MATERIAL = "1.3.1"
    const val COMPOSE_FOUNDATION = "1.3.1"
    const val COMPOSE_COMPILER = "1.4.2"
    const val COMPOSE_ACTIVITY = "1.6.1"
    const val COMPOSE_NAVIGATION = "2.5.3"
    const val COMPOSE_HILT_NAVIGATION = "1.0.0"
    const val COMPOSE_LIFECYCLE = "2.6.0-beta01"
}

object PresentationDependency {
    const val APPCOMPAT = "androidx.appcompat:appcompat:${PresentationVersions.APPCOMPAT}"

    const val COMPOSE_UI = "androidx.compose.ui:ui:${PresentationVersions.COMPOSE}"
    const val COMPOSE_RUNTIME = "androidx.compose.runtime:runtime:${PresentationVersions.COMPOSE}"
    const val COMPOSE_TOOLING = "androidx.compose.ui:ui-tooling:${PresentationVersions.COMPOSE}"
    const val COMPOSE_TOOLING_PREVIEW = "androidx.compose.ui:ui-tooling-preview:${PresentationVersions.COMPOSE}"
    const val COMPOSE_ANIMATION = "androidx.compose.animation:animation:${PresentationVersions.COMPOSE}"

    const val COMPOSE_MATERIAL = "androidx.compose.material:material:${PresentationVersions.COMPOSE_MATERIAL}"
    const val COMPOSE_FOUNDATION = "androidx.compose.foundation:foundation:${PresentationVersions.COMPOSE_FOUNDATION}"
    const val COMPOSE_COMPILER = "androidx.compose.compiler:compiler:${PresentationVersions.COMPOSE_COMPILER}"
    const val COMPOSE_ACTIVITY = "androidx.activity:activity-compose:${PresentationVersions.COMPOSE_ACTIVITY}"
    const val COMPOSE_NAVIGATION = "androidx.navigation:navigation-compose:${PresentationVersions.COMPOSE_NAVIGATION}"
    const val COMPOSE_HILT_NAVIGATION = "androidx.hilt:hilt-navigation-compose:${PresentationVersions.COMPOSE_HILT_NAVIGATION}"
    const val COMPOSE_LIFECYCLE = "androidx.lifecycle:lifecycle-runtime-compose:${PresentationVersions.COMPOSE_LIFECYCLE}"
}
