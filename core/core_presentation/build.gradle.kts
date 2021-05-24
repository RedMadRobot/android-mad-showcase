plugins {
    id(GradlePluginId.ANDROID_LIBRARY)
    id(GradlePluginId.ANDROID_COMMON_CONFIG)
}

dependencies {
    implementation(project(":core:core_common"))

    api(PresentationDependency.APPCOMPAT)
    api(PresentationDependency.COMPOSE_UI)
    api(PresentationDependency.COMPOSE_ANIMATION)
    api(PresentationDependency.COMPOSE_COMPILER)
    api(PresentationDependency.COMPOSE_TOOLING)
    api(PresentationDependency.COMPOSE_FOUNDATION)
    api(PresentationDependency.COMPOSE_MATERIAL)
    api(PresentationDependency.COMPOSE_ACTIVITY)
}
