plugins {
    alias(libs.plugins.gamerguide.kotlin.library)
}

dependencies {
    implementation(projects.feature.home.data.contract)
    implementation(projects.feature.home.domain.contract)

    implementation(libs.paging.common)

    // Koin
    implementation(platform(libs.koin.bom))
    implementation(libs.koin.core)
}
