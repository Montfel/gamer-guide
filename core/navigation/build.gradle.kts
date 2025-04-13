plugins {
    alias(libs.plugins.kotlin.serialization)

    alias(libs.plugins.gamerguide.compose.library)
}

android {
    namespace = "${libs.versions.app.namespace.get()}.core.navigation"
}

dependencies {
    implementation(projects.core.designsystem)

    implementation(projects.feature.gamedetails.ui)
    implementation(projects.feature.home.ui)
    implementation(projects.feature.lists.ui)

    implementation(libs.navigation)

    // Compose
    implementation(platform(libs.compose.bom))
    implementation(libs.compose.material3)
    implementation(libs.compose.foundation)
    implementation(libs.compose.ui.tooling)

    // Kotlin Serialization
    implementation(libs.kotlin.serialization.core)
}
