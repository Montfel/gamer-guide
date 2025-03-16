plugins {
    alias(libs.plugins.gamerguide.kotlin.library)
}

dependencies {
    implementation(projects.core.common)

    // Paging
    implementation(libs.paging.common)
}
