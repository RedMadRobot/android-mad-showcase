object GradlePluginVersions {
    const val ANDROID_BUILD_TOOLS = "7.0.0-alpha05"
    const val KOTLIN = CoreVersions.KOTLIN
    const val HILT = CoreVersions.HILT
}

object GradlePluginId {
    const val ANDROID_COMMON_CONFIG = "common-android-config"
    const val ANDROID_APPLICATION = "com.android.application"
    const val ANDROID_LIBRARY = "com.android.library"
    const val KAPT = "kapt"
    const val HILT = "dagger.hilt.android.plugin"
}

object GradlePluginDependency {
    const val ANDROID_BUILD_TOOLS = "com.android.tools.build:gradle:${GradlePluginVersions.ANDROID_BUILD_TOOLS}"
    const val KOTLIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:${GradlePluginVersions.KOTLIN}"
    const val HILT = "com.google.dagger:hilt-android-gradle-plugin:${GradlePluginVersions.HILT}"
}