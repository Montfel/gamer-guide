plugins {
    alias(libs.plugins.gamerguide.compose.library)
}

android {
    namespace = "com.montfel.gamerguide.core.designsystem"
}

dependencies {
    implementation(projects.core.common)

    implementation(platform(libs.compose.bom))
    implementation(libs.compose.material3)
    implementation(libs.compose.foundation)
    implementation(libs.compose.ui.tooling)
    implementation(libs.splash)
}
