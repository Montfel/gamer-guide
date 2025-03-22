plugins {
    id(libs.plugins.google.services.get().pluginId)
    id(libs.plugins.firebase.crashlytics.gradle.get().pluginId)

    alias(libs.plugins.gamerguide.android.application)
}

android {
    namespace = "${libs.versions.app.namespace.get()}.feature.gamedetails.appdemo"

    defaultConfig {
        applicationId = "${libs.versions.app.namespace.get()}.feature.gamedetails.appdemo"
    }
}

dependencies {
    implementation(projects.core.common)

    implementation(projects.feature.gamedetails.ui)

    implementation(libs.activity)

    // Firebase
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.crashlytics)

    // Koin
    implementation(platform(libs.koin.bom))
    implementation(libs.koin.android)
    implementation(libs.koin.core)
}
