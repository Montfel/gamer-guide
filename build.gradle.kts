ext {
    extra["compile_sdk"] = 33
    extra["target_sdk"] = 33
    extra["min_sdk"] = 21

    extra["core"] = "1.9.0"
    extra["coil"] = "2.2.1"
    extra["compose"] = "1.3.0-beta03"
    extra["compose_compiler"] = "1.3.1"
    extra["retrofit"] = "2.9.0"
    extra["okhttp"] = "4.10.0"
    extra["accompanist"] = "0.26.4-beta"
    extra["lifecycle"] = "2.6.0-alpha02"
    extra["firebase"] = "30.5.0"
    extra["material3"] = "1.0.0-beta03"
    extra["activity"] = "1.6.0"
    extra["junit"] = "4.13.2"
    extra["navigation"] = "2.5.2"
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.44")
        classpath("com.google.gms:google-services:4.3.14")
        classpath("com.google.firebase:firebase-crashlytics-gradle:2.9.2")
    }
}// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version ("8.0.0-alpha03") apply false
    id("com.android.library") version ("8.0.0-alpha03") apply false
    id("org.jetbrains.kotlin.android") version ("1.7.10") apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
