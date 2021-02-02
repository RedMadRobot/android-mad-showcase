object GradlePluginVersions {
    const val ANDROID_BUILD_TOOLS = "7.0.0-alpha05"
    const val KOTLIN = CoreVersions.KOTLIN
}

object GradlePlugin {
    const val ANDROID_BUILD_TOOLS = "com.android.tools.build:gradle:${GradlePluginVersions.ANDROID_BUILD_TOOLS}"
    const val KOTLIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:${GradlePluginVersions.KOTLIN}"
}
