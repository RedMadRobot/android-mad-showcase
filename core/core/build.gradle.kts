plugins {
    id(GradlePluginId.ANDROID_LIBRARY)
    id(GradlePluginId.ANDROID_COMMON_CONFIG)
}

dependencies {
    api(project(":core:core_presentation"))
    api(project(":core:core_network"))


    // common
    api(CoreDependency.KOTLIN)
    api(CoreDependency.COROUTINES_CORE)
    api(CoreDependency.COROUTINES_ANDROID)
}
