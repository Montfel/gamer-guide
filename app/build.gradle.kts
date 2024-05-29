plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id(libs.plugins.google.services.get().pluginId)
    id(libs.plugins.firebase.crashlytics.gradle.get().pluginId)
    alias(libs.plugins.ksp)
    id(libs.plugins.hilt.get().pluginId)
    alias(libs.plugins.compose.compiler)

    alias(libs.plugins.gamerguide.android.application)
}

android {
    namespace = "com.montfel.gamerguide"

    defaultConfig {
        applicationId = "com.montfel.gamerguide"
    }
}

dependencies {
    implementation(projects.core.designsystem)

    implementation(projects.feature.data)
    implementation(projects.feature.domain)
    implementation(projects.feature.ui)

    implementation(libs.activity)
    implementation(libs.core)
    implementation(libs.destinations.core)
    ksp(libs.destinations.ksp)
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.analytics)
    implementation(libs.firebase.crashlytics)
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    implementation(libs.hilt.navigation)
    implementation(libs.bundles.lifecycle)
    implementation(libs.splash)

    testImplementation(libs.junit.test)
    androidTestImplementation(libs.junit.test.android)
    androidTestImplementation(libs.espresso)
}
