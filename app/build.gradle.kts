plugins {
    id(libs.plugins.google.services.get().pluginId)
    id(libs.plugins.firebase.crashlytics.gradle.get().pluginId)
    alias(libs.plugins.kotlin.serialization)

    alias(libs.plugins.gamerguide.android.application)
}

android {
    namespace = libs.versions.app.namespace.get()

    defaultConfig {
        applicationId =  libs.versions.app.namespace.get()
    }

    androidResources {
        generateLocaleConfig = true
    }
}

dependencies {
    implementation(projects.core.common)
    implementation(projects.core.designsystem)

    implementation(projects.feature.data)

    implementation(projects.feature.gamedetails.ui)
    implementation(projects.feature.home.ui)

    implementation(libs.activity)
    implementation(libs.core)
    implementation(libs.navigation)
    implementation(libs.splash)

    // Firebase
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.crashlytics)

    // Koin
    implementation(platform(libs.koin.bom))
    implementation(libs.koin.android)
    implementation(libs.koin.core)
    implementation(libs.koin.viewmodel)

    // Kotlin Serialization
    implementation(libs.kotlin.serialization.core)
}
