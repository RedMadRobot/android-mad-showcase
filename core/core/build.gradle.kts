plugins {
    id(GradlePluginId.ANDROID_LIBRARY)
    id(GradlePluginId.ANDROID_COMMON_CONFIG)
}

dependencies {
    api(CoreDependency.KOTLIN)
    api(CoreDependency.COROUTINES_CORE)
    api(CoreDependency.COROUTINES_ANDROID)

    api(project(":core:core_network"))
    api(project(":core:core_presentation"))
    api(project(":core:core_navigation"))
}
