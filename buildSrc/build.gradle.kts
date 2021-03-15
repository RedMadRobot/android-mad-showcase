plugins {
    `kotlin-dsl`
}

repositories {
    jcenter()
    google()
}

dependencies {
    implementation("com.android.tools.build:gradle:7.0.0-alpha09")
    implementation("com.android.tools.build:gradle-api:7.0.0-alpha09")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.31")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin-api:1.4.31")
}

gradlePlugin {
    plugins {
        register("common-android-config") {
            id = "common-android-config"
            implementationClass = "com.redmadrobot.mad.plugins.CommonAndroidConfigPlugin"
        }
    }
}
