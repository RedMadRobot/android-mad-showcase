import java.util.*

plugins {
    id(GradlePluginId.ANDROID_APPLICATION)
    kotlin(GradlePluginId.KOTLIN_ANDROID)
}

android {
    defaultConfig {

        applicationId = "com.redmadrobot.mad"

        minSdkVersion(AndroidConfigVersions.MIN_SDK_VERSION)
        targetSdkVersion(AndroidConfigVersions.TARGET_SDK_VERSION)
        compileSdkVersion(AndroidConfigVersions.COMPILE_SDK_VERSION)
        buildToolsVersion(AndroidConfigVersions.BUILD_TOOLS_VERSION)
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerVersion = CoreVersions.KOTLIN
        kotlinCompilerExtensionVersion = CoreVersions.COMPOSE
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
        useIR = true
    }
}

dependencies {
    implementation(UIDependency.APPCOMPAT)
    implementation(UIDependency.CONSTRAINT_LAYOUT)
    implementation(UIDependency.MATERIAL_UI)

    implementation(UIDependency.COMPOSE_UI)
    implementation(UIDependency.COMPOSE_COMPILER)
    implementation(UIDependency.COMPOSE_FOUNDATION)
    implementation(UIDependency.COMPOSE_MATERIAL_UI)
    implementation(UIDependency.COMPOSE_ICON)
    implementation(UIDependency.COMPOSE_ICON_EXTENDED)
    implementation(UIDependency.COMPOSE_LIVEDATA)
    implementation(UIDependency.COMPOSE_TOOLING)
}
