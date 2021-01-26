import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        google()
        jcenter()
        maven("https://dl.bintray.com/kotlin/kotlin-eap/")
    }
    dependencies {
        classpath(GradlePlugin.ANDROID_BUILD_TOOLS)
        classpath(GradlePlugin.KOTLIN)
    }
}

subprojects {
    repositories {
        google()
        jcenter()
        maven("https://dl.bintray.com/kotlin/kotlin-eap/")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}