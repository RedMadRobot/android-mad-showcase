plugins {
    id(GradlePluginId.ANDROID_LIBRARY)
    id(GradlePluginId.ANDROID_COMMON_CONFIG)
}

dependencies {
    api(PresentationDependency.COMPOSE_NAVIGATION)
    api(PresentationDependency.COMPOSE_HILT_NAVIGATION)
}
