plugins {
    id(GradlePluginId.ANDROID_LIBRARY)
    id(GradlePluginId.ANDROID_COMMON_CONFIG)
}

dependencies {
    implementation(project(":core:core_common"))

    api(PresentationDependency.COMPOSE_NAVIGATION)
    api(PresentationDependency.COMPOSE_HILT_NAVIGATION)
}
