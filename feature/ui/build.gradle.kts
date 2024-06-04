plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.compose.compiler)

    alias(libs.plugins.gamerguide.android.library.compose)
}

android {
    namespace = "com.montfel.gamerguide.feature.ui"
}

dependencies {
    implementation(projects.core.common)
    implementation(projects.core.designsystem)

    implementation(projects.feature.domain)

    implementation(libs.coil)
    implementation(platform(libs.compose.bom))
    implementation(libs.bundles.compose)
    implementation(libs.core)
    implementation(libs.destinations.core)
    ksp(libs.destinations.ksp)
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    implementation(libs.hilt.navigation)
    implementation(libs.bundles.lifecycle)

    testImplementation(libs.junit.test)
    androidTestImplementation(libs.junit.test.android)
    androidTestImplementation(libs.espresso)
}