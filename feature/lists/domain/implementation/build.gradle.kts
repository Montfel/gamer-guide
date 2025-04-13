plugins {
    alias(libs.plugins.gamerguide.kotlin.library)
}

dependencies {
    implementation(projects.feature.lists.data.contract)
    implementation(projects.feature.lists.domain.contract)

    implementation(libs.kotlin.coroutines.core)

    // Koin
    implementation(platform(libs.koin.bom))
    implementation(libs.koin.core)
}
