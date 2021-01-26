object CoreVersions {
    const val KOTLIN = "1.4.21"
    const val COROUTINES = "1.4.2"
    const val COMPOSE = "1.0.0-alpha10"
}

object CoreDependency {
    const val KOTLIN_STDLIB = "org.jetbrains.kotlin:kotlin-stdlib:${CoreVersions.KOTLIN}"
    const val COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${CoreVersions.COROUTINES}"
}
