plugins {
    id(GradlePluginId.ANDROID_LIBRARY)
    id(GradlePluginId.ANDROID_COMMON_CONFIG)
}

dependencies {
    api(PresentationDependency.APPCOMPAT)
    api(PresentationDependency.COMPOSE_UI)
    api(PresentationDependency.COMPOSE_ANIMATION)
    api(PresentationDependency.COMPOSE_COMPILER)
    api(PresentationDependency.COMPOSE_TOOLING)
    api(PresentationDependency.COMPOSE_TOOLING_PREVIEW)
    api(PresentationDependency.COMPOSE_FOUNDATION)
    api(PresentationDependency.COMPOSE_MATERIAL)
    api(PresentationDependency.COMPOSE_ACTIVITY)
    api(PresentationDependency.COMPOSE_LIFECYCLE)
}
