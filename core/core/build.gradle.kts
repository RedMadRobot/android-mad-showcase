plugins {
    id(GradlePluginId.ANDROID_LIBRARY)
    id(GradlePluginId.ANDROID_COMMON_CONFIG)
}

dependencies {
    api(project(":core:core_common"))
    api(project(":core:core_network"))
    api(project(":core:core_presentation"))
    api(project(":core:core_navigation"))
}
