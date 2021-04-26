object CoreVersions {
    const val KOTLIN = "1.4.31"
    const val COROUTINES = "1.4.2"

    const val HILT = "2.33-beta"

    const val APOLLO = "2.5.6"
}

object CoreDependency {
    const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${CoreVersions.KOTLIN}"

    const val COROUTINES_CORE =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${CoreVersions.COROUTINES}"
    const val COROUTINES_ANDROID =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${CoreVersions.COROUTINES}"

    const val HILT = "com.google.dagger:hilt-android:${CoreVersions.HILT}"
    const val HILT_COMPILER = "com.google.dagger:hilt-compiler:${CoreVersions.HILT}"
}
