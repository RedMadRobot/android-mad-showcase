plugins {
    id(GradlePluginId.ANDROID_LIBRARY)
    id(GradlePluginId.ANDROID_COMMON_CONFIG)
    kotlin(GradlePluginId.KAPT)
    id(GradlePluginId.HILT)
}

dependencies {
    implementation(project(":core:core"))
    implementation(project(":base:base_cards"))

    implementation(CoreDependency.HILT)
    kapt(CoreDependency.HILT_COMPILER)
}
