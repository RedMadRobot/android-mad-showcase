plugins {
    // pre-load plugins
    id(GradlePluginId.ANDROID_APPLICATION) version GradlePluginVersions.ANDROID_GRADLE apply false
    kotlin(GradlePluginId.KOTLIN_ANDROID) version GradlePluginVersions.KOTLIN apply false
    kotlin(GradlePluginId.KOTLIN_ANDROID_EXTENSIONS) version GradlePluginVersions.KOTLIN apply false
}

// all projects = root project + sub projects
allprojects {
    repositories {
        google()
        mavenCentral()
        jcenter()
        maven { url = uri("https://jitpack.io") }
    }
}
