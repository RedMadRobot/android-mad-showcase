plugins {
    id(GradlePluginId.ANDROID_APPLICATION)
    id(GradlePluginId.ANDROID_COMMON_CONFIG)
    kotlin(GradlePluginId.KAPT)
    id(GradlePluginId.HILT)
}

android {
    defaultConfig {
        applicationId = "com.redmadrobot.mad"
    }
}

dependencies {
    implementation(project(":core:core"))

    implementation(CoreDependency.HILT)
    kapt(CoreDependency.HILT_COMPILER)
}
