plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)

    alias(libs.plugins.gamerguide.android.library.compose)
}

android {
    namespace = "com.montfel.gamerguide.core.designsystem"
}

dependencies {
    implementation(projects.core.common)

    implementation(libs.accompanist)
    implementation(platform(libs.compose.bom))
    implementation(libs.bundles.compose)
    implementation(libs.core)
    implementation(libs.splash)

    testImplementation(libs.junit.test)
    androidTestImplementation(libs.junit.test.android)
    androidTestImplementation(libs.espresso)
}