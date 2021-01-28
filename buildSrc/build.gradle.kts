plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

repositories {
    jcenter()
    google()
}

dependencies {
    implementation("com.android.tools.build:gradle:7.0.0-alpha04")
    implementation("com.android.tools.build:gradle-api:7.0.0-alpha04")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.21")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin-api:1.4.21")
}

gradlePlugin {
    plugins {
        register("common-android-config") {
            id = "common-android-config"
            implementationClass = "com.redmadrobot.mad.plugins.CommonAndroidConfigPlugin"
        }
    }
}