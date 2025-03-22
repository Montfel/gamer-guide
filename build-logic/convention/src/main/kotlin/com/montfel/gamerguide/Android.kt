package com.montfel.gamerguide

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension
import java.util.Properties

internal fun Project.configureAndroidApplication(
    applicationExtension: ApplicationExtension,
) {
    applicationExtension.apply {
        val secretsFile = rootProject.file("secrets.properties")
        val secretsProperties = Properties()
        secretsProperties.load(secretsFile.inputStream())

        defaultConfig {
            targetSdk = libs.versions.sdk.target.get().toInt()
            versionCode = libs.versions.versionCode.get().toInt()
            versionName = libs.versions.versionName.get()

            vectorDrawables {
                useSupportLibrary = true
            }
        }

        buildTypes {
            debug {
                isMinifyEnabled = false
                isDebuggable = true

                buildConfigField(
                    "String",
                    "BASE_URL",
                    secretsProperties.getProperty("baseUrl")
                )
            }

            release {
                isMinifyEnabled = true
                isShrinkResources = true
                proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
                signingConfig = signingConfigs.getByName("debug")

                buildConfigField(
                    "String",
                    "BASE_URL",
                    secretsProperties.getProperty("baseUrl")
                )
            }
        }

        buildFeatures {
            buildConfig = true
        }

        packaging {
            resources {
                excludes += "/META-INF/{AL2.0,LGPL2.1}"
            }
        }

        configureAndroid(applicationExtension)
    }

    configureKotlin()
}

internal fun Project.configureAndroidLibrary(
    libraryExtension: LibraryExtension,
) {
    libraryExtension.apply {
        buildTypes {
            debug {
                isMinifyEnabled = false
            }
            release {
                isMinifyEnabled = true
            }
        }

        configureAndroid(libraryExtension)
    }

    configureKotlin()
}

internal fun Project.applyAndroidLibraryPlugins() {
    apply(plugin = libs.plugins.android.library.get().pluginId)
    apply(plugin = libs.plugins.kotlin.android.get().pluginId)
    apply(plugin = libs.plugins.dependency.analysis.get().pluginId)
}

internal fun Project.applyAndroidApplicationPlugins() {
    apply(plugin = libs.plugins.android.application.get().pluginId)
    apply(plugin = libs.plugins.kotlin.android.get().pluginId)
    apply(plugin = libs.plugins.dependency.analysis.get().pluginId)
}

private fun Project.configureAndroid(
    commonExtension: CommonExtension<*, *, *, *, *, *>,
) {
    commonExtension.apply {
        compileSdk = libs.versions.sdk.compile.get().toInt()

        defaultConfig {
            minSdk = libs.versions.sdk.min.get().toInt()

            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_21
            targetCompatibility = JavaVersion.VERSION_21
        }
    }
}

private fun Project.configureKotlin() {
    extensions.configure<KotlinAndroidProjectExtension> {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_21)
        }
    }
}
