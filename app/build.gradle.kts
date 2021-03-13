plugins {
    id(GradlePluginId.ANDROID_APPLICATION)
    id(GradlePluginId.ANDROID_COMMON_CONFIG)
    kotlin(GradlePluginId.KAPT)
}

android {
    defaultConfig {
        applicationId = "com.redmadrobot.mad"
    }
}

dependencies {
    implementation(project(":core:core"))

    kapt(CoreDependency.HILT_COMPILER)
}
