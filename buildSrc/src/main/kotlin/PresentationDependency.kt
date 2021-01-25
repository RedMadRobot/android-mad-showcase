private object PresentationVersions {
    const val APPCOMPAT = "1.2.0"
    const val CONSTRAINT_LAYOUT = "2.0.4"
    const val MATERIAL_UI = "1.2.1"
}

object PresentationDependency {
    const val APPCOMPAT = "androidx.appcompat:appcompat:${PresentationVersions.APPCOMPAT}"
    const val CONSTRAINT_LAYOUT =
        "androidx.constraintlayout:constraintlayout:${PresentationVersions.CONSTRAINT_LAYOUT}"
    const val MATERIAL_UI = "com.google.android.material:material:${PresentationVersions.MATERIAL_UI}"

    const val COMPOSE_UI = "androidx.compose.ui:ui:${CoreVersions.COMPOSE}"
    const val COMPOSE_RUNTIME = "androidx.compose.runtime:runtime:${CoreVersions.COMPOSE}"
    const val COMPOSE_COMPILER = "androidx.compose.compiler:compiler:${CoreVersions.COMPOSE}"
    const val COMPOSE_NAVIGATION = "androidx.navigation:navigation-compose:${CoreVersions.COMPOSE_NAVIGATION}"
    const val COMPOSE_TOOLING = "androidx.compose.ui:ui-tooling:${CoreVersions.COMPOSE}"
    const val COMPOSE_FOUNDATION = "androidx.compose.foundation:foundation:${CoreVersions.COMPOSE}"
    const val COMPOSE_FOUNDATION_LAYOUT = "androidx.compose.foundation:foundation-layout:${CoreVersions.COMPOSE}"
    const val COMPOSE_MATERIAL = "androidx.compose.material:material:${CoreVersions.COMPOSE}"
}
