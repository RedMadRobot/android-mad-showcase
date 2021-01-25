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

task<Delete>("clean") {
    delete(rootProject.buildDir)
}