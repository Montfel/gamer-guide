package com.montfel.gamerguide

import ProjectConfig
import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension

internal fun Project.configureAndroidApplication(
    applicationExtension: ApplicationExtension,
) {
    applicationExtension.apply {
        defaultConfig {
            targetSdk = ProjectConfig.targetSdkVersion
            versionCode = ProjectConfig.versionCode
            versionName = ProjectConfig.versionName

            vectorDrawables {
                useSupportLibrary = true
            }
        }

        buildTypes {
            debug {
                isMinifyEnabled = false
                isDebuggable = true
            }
            release {
                isMinifyEnabled = true
                isShrinkResources = true
                proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
                signingConfig = signingConfigs.getByName("debug")
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
        androidResources {
            generateLocaleConfig = true
        }

        configureAndroid(applicationExtension)
    }

    configureKotlin()
}

internal fun Project.configureAndroidLibrary(
    libraryExtension: LibraryExtension,
) {
    libraryExtension.apply {
        defaultConfig {
            consumerProguardFiles("consumer-rules.pro")
        }

        buildTypes {
            debug {
                isMinifyEnabled = false
            }
            release {
                isMinifyEnabled = true
                proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            }
        }

        configureAndroid(libraryExtension)
    }

    configureKotlin()
}

private fun configureAndroid(
    commonExtension: CommonExtension<*, *, *, *, *, *>,
) {
    commonExtension.apply {
        compileSdk = ProjectConfig.compileSdkVersion

        defaultConfig {
            minSdk = ProjectConfig.minSdkVersion

            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
        }
    }
}

private fun Project.configureKotlin() {
    with(extensions.getByType<KotlinAndroidProjectExtension>()) {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }
    }
}
