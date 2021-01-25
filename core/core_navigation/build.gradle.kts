plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    defaultConfig {
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
    implementation(CoreDependency.KOTLIN_STDLIB)
    implementation(PresentationDependency.COMPOSE_RUNTIME)
    implementation(PresentationDependency.COMPOSE_FOUNDATION_LAYOUT)
    implementation(PresentationDependency.COMPOSE_TOOLING)
}