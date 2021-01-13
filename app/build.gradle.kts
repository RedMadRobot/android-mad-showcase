import java.util.*

plugins {
    id(GradlePluginId.ANDROID_APPLICATION)
    kotlin(GradlePluginId.KOTLIN_ANDROID)
    kotlin(GradlePluginId.KOTLIN_ANDROID_EXTENSIONS)
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

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

dependencies {
    implementation(UIDependency.APPCOMPAT)
    implementation(UIDependency.CONSTRAINT_LAYOUT)
    implementation(UIDependency.MATERIAL_UI)
}
