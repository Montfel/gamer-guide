plugins {
    alias(libs.plugins.gamerguide.compose.library)
}

android {
    namespace = "${libs.versions.app.namespace.get()}.core.designsystem"
}

dependencies {
    implementation(libs.splash)

    // Compose
    implementation(platform(libs.compose.bom))
    implementation(libs.compose.material3)
    implementation(libs.compose.foundation)
    implementation(libs.compose.ui.tooling)
}
