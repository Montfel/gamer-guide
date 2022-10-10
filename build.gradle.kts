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
