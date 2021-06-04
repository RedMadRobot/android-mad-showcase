plugins {
    id(GradlePluginId.ANDROID_LIBRARY)
    id(GradlePluginId.ANDROID_COMMON_CONFIG)
}

dependencies {
    // TODO: delete next line after update compose navigation and hilt navigation because these libs have target 1.0.0-rc01 compose runtime
    implementation(PresentationDependency.COMPOSE_RUNTIME)
    api(PresentationDependency.COMPOSE_NAVIGATION)
    api(PresentationDependency.COMPOSE_HILT_NAVIGATION)
}
