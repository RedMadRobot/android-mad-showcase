plugins {
    id(GradlePluginId.ANDROID_LIBRARY)
    id(GradlePluginId.ANDROID_COMMON_CONFIG)
}

dependencies {
    api(project(":core:core_presentation"))


    // common
    api(CoreDependency.KOTLIN)
    api(CoreDependency.COROUTINES_CORE)
    api(CoreDependency.COROUTINES_ANDROID)

    // presentation
    api(PresentationDependency.APPCOMPAT)
    api(PresentationDependency.COMPOSE_UI)
    api(PresentationDependency.COMPOSE_COMPILER)
    api(PresentationDependency.COMPOSE_TOOLING)
    api(PresentationDependency.COMPOSE_FOUNDATION)
    api(PresentationDependency.COMPOSE_MATERIAL)
    api(PresentationDependency.COMPOSE_ACTIVITY)
}
