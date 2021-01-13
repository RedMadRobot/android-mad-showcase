pluginManagement {

    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        jcenter()
        maven { url = uri("https://jitpack.io") }
    }

    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "com.android.library" -> useModule("com.android.tools.build:gradle:${requested.version}")
                "com.android.application" -> useModule("com.android.tools.build:gradle:${requested.version}")
            }
        }
    }
}

rootProject.name = ("android-mad-showcase")

include("app")
