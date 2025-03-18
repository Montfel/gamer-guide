plugins {
    alias(libs.plugins.gamerguide.compose.library)
}

android {
    namespace = "${libs.versions.app.namespace.get()}.feature.gamedetails.ui"
}

dependencies {
    implementation(projects.core.common)
    implementation(projects.core.designsystem)

    implementation(projects.feature.gamedetails.domain.contract)

    implementation(projects.feature.domain)

    implementation(libs.coil)

    // Compose
    implementation(platform(libs.compose.bom))
    implementation(libs.compose.material3)
    implementation(libs.compose.foundation)
    implementation(libs.compose.ui.tooling)

    // Lifecycle
    implementation(libs.lifecycle.compose)

    // Koin
    implementation(platform(libs.koin.bom))
    implementation(libs.koin.compose)
}
