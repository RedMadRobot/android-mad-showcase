object PresentationVersions {
    const val APPCOMPAT = "1.3.0-beta01"

    const val COMPOSE = "1.0.0-beta04"
    const val COMPOSE_ACTIVITY = "1.3.0-alpha07"
    const val COMPOSE_NAVIGATION = "1.0.0-alpha10"
    const val COMPOSE_HILT_NAVIGATION = "1.0.0-alpha01"
}

object PresentationDependency {
    const val APPCOMPAT = "androidx.appcompat:appcompat:${PresentationVersions.APPCOMPAT}"

    const val COMPOSE_UI = "androidx.compose.ui:ui:${PresentationVersions.COMPOSE}"
    const val COMPOSE_RUNTIME = "androidx.compose.runtime:runtime:${PresentationVersions.COMPOSE}"
    const val COMPOSE_COMPILER = "androidx.compose.compiler:compiler:${PresentationVersions.COMPOSE}"
    const val COMPOSE_TOOLING = "androidx.compose.ui:ui-tooling:${PresentationVersions.COMPOSE}"
    const val COMPOSE_FOUNDATION = "androidx.compose.foundation:foundation:${PresentationVersions.COMPOSE}"
    const val COMPOSE_FOUNDATION_LAYOUT = "androidx.compose.foundation:foundation-layout:${PresentationVersions.COMPOSE}"
    const val COMPOSE_MATERIAL = "androidx.compose.material:material:${PresentationVersions.COMPOSE}"

    const val COMPOSE_ACTIVITY = "androidx.activity:activity-compose:${PresentationVersions.COMPOSE_ACTIVITY}"
    const val COMPOSE_NAVIGATION = "androidx.navigation:navigation-compose:${PresentationVersions.COMPOSE_NAVIGATION}"
    const val COMPOSE_HILT_NAVIGATION = "androidx.hilt:hilt-navigation-compose:${PresentationVersions.COMPOSE_HILT_NAVIGATION}"
}
