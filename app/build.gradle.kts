plugins {
    id("com.android.application")
    kotlin("android")
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
    implementation(project(":core:core_navigation"))

    implementation(PresentationDependency.APPCOMPAT)
    implementation(PresentationDependency.CONSTRAINT_LAYOUT)
    implementation(PresentationDependency.MATERIAL_UI)

    implementation(PresentationDependency.COMPOSE_UI)
    implementation(PresentationDependency.COMPOSE_COMPILER)
    implementation(PresentationDependency.COMPOSE_NAVIGATION)
    implementation(PresentationDependency.COMPOSE_TOOLING)
    implementation(PresentationDependency.COMPOSE_FOUNDATION)
    implementation(PresentationDependency.COMPOSE_FOUNDATION_LAYOUT)
    implementation(PresentationDependency.COMPOSE_MATERIAL)
}
