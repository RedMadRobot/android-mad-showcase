package com.redmadrobot.mad.plugins

import AndroidConfigVersions
import CoreVersions
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class CommonAndroidConfigPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            applyPlugins()
            applyAndroidConfig()
            applyKotlinConfig()
        }
    }

    private fun Project.applyPlugins() {
        plugins.run {
            apply("kotlin-android")
        }
    }

    private fun Project.applyAndroidConfig() {
        android?.run {
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

            composeOptions {
                kotlinCompilerVersion = CoreVersions.KOTLIN
                kotlinCompilerExtensionVersion = CoreVersions.COMPOSE
            }

            sourceSets.forEach { it.java.srcDir("src/${it.name}/kotlin") }
        }
        app?.run {
            buildFeatures {
                compose = true
            }
        }
        library?.run {
            buildFeatures {
                compose = true
            }
        }
    }

    private fun Project.applyKotlinConfig() {
        this.tasks.withType<KotlinCompile> {
            kotlinOptions {
                jvmTarget = JavaVersion.VERSION_1_8.toString()
                useIR = true
            }
        }
    }
}