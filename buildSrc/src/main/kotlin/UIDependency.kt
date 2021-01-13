private object UIVersions {
    const val APPCOMPAT = "1.2.0"
    const val CONSTRAINT_LAYOUT = "2.0.4"
    const val MATERIAL_UI = "1.2.1"
}

object UIDependency {
    const val APPCOMPAT = "androidx.appcompat:appcompat:${UIVersions.APPCOMPAT}"
    const val CONSTRAINT_LAYOUT =
        "androidx.constraintlayout:constraintlayout:${UIVersions.CONSTRAINT_LAYOUT}"
    const val MATERIAL_UI = "com.google.android.material:material:${UIVersions.MATERIAL_UI}"

    const val COMPOSE_UI = "androidx.compose.ui:ui:${CoreVersions.COMPOSE}"
    const val COMPOSE_COMPILER = "androidx.compose.compiler:compiler:${CoreVersions.COMPOSE}"
    const val COMPOSE_TOOLING = "androidx.compose.ui:ui-tooling:${CoreVersions.COMPOSE}"
    const val COMPOSE_FOUNDATION = "androidx.compose.foundation:foundation:${CoreVersions.COMPOSE}"
    const val COMPOSE_MATERIAL_UI = "androidx.compose.material:material:${CoreVersions.COMPOSE}"
    const val COMPOSE_ICON = "androidx.compose.material:material-icons-core:${CoreVersions.COMPOSE}"
    const val COMPOSE_ICON_EXTENDED = "androidx.compose.material:material-icons-extended:${CoreVersions.COMPOSE}"
    const val COMPOSE_LIVEDATA = "androidx.compose.runtime:runtime-livedata:${CoreVersions.COMPOSE}"
}
