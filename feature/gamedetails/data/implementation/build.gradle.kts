plugins {
    alias(libs.plugins.kotlin.serialization)

    alias(libs.plugins.gamerguide.android.library)
}

android {
    namespace = "${libs.versions.app.namespace.get()}.feature.gamedetails.data.implementation"
}

dependencies {
    implementation(projects.core.common)
    implementation(projects.core.network)

    implementation(projects.feature.gamedetails.data.contract)

    implementation(projects.feature.domain)

    // Firebase
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.analytics)
    implementation(libs.firebase.config)

    // OkHttp
    implementation(platform(libs.okhttp.bom))
    implementation(libs.bundles.okhttp)

    // Koin
    implementation(platform(libs.koin.bom))
    implementation(libs.koin.core)

    // Kotlin Serialization
    implementation(libs.kotlin.serialization.core)
    implementation(libs.kotlin.serialization.json)

    // Ktor
    implementation(libs.ktor.client.android)
    implementation(libs.ktor.client.content.negotiation)
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.okhttp)
    implementation(libs.ktor.client.serialization.json)
}
