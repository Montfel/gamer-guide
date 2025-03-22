plugins {
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

    implementation(projects.feature.gamedetails.data.implementation)
    implementation(projects.feature.gamedetails.domain.implementation)
    implementation(projects.feature.gamedetails.ui)

    implementation(projects.core.network)

    implementation(libs.activity)

    // Koin
    implementation(platform(libs.koin.bom))
    implementation(libs.koin.android)
    implementation(libs.koin.core)
}
