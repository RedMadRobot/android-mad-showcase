plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    google()
}

dependencies {
    implementation("com.android.tools.build:gradle:7.4.1")
    implementation("com.android.tools.build:gradle-api:7.4.1")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.10")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin-api:1.8.10")
    implementation("com.squareup:javapoet:1.13.0") // https://github.com/google/dagger/issues/3068
}

gradlePlugin {
    plugins {
        register("common-android-config") {
            id = "common-android-config"
            implementationClass = "com.redmadrobot.mad.plugins.CommonAndroidConfigPlugin"
        }
    }
}
