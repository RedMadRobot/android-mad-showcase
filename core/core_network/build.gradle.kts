plugins {
    id(GradlePluginId.ANDROID_LIBRARY)
    id(GradlePluginId.ANDROID_COMMON_CONFIG)
    id(GradlePluginId.APOLLO)
}

android {
    buildFeatures {
        compose = false
    }
}

apollo {
    generateApolloMetadata.set(true)
    generateKotlinModels.set(true)
}

dependencies {
    implementation(project(":core:core_common"))

    api(NetworkDependency.APOLLO_GRAPHQL)
    api(NetworkDependency.APOLLO_COROUTINES)
}
