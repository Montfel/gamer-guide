plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)

    alias(libs.plugins.gamerguide.android.library)
}

android {
    namespace = "com.montfel.gamerguide.feature.data"
}

dependencies {
    implementation(projects.core.common)

    implementation(projects.feature.domain)

    implementation(libs.core)
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.analytics)
    implementation(libs.firebase.config)
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    implementation(platform(libs.okhttp.bom))
    implementation(libs.bundles.okhttp)
    implementation(libs.bundles.retrofit)

    testImplementation(libs.junit.test)
    androidTestImplementation(libs.junit.test.android)
    androidTestImplementation(libs.espresso)
}
