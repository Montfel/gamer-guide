buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(libs.google.services)
        classpath(libs.firebase.crashlytics.gradle)
    }
}// Top-level build file where you can add configuration options common to all sub-projects/modules.
@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    // TODO: change to alias
//    alias(libs.plugins.android.application)
    id(libs.plugins.android.application.get().pluginId) version (libs.versions.gradle.get()) apply false
    id(libs.plugins.android.library.get().pluginId) version (libs.versions.gradle.get()) apply false
    id(libs.plugins.kotlin.android.get().pluginId) version (libs.versions.kotlin.get()) apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
