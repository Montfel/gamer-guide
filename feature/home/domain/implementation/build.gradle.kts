plugins {
    alias(libs.plugins.gamerguide.kotlin.library)
}

dependencies {
    implementation(projects.feature.home.data.contract)
    implementation(projects.feature.home.domain.contract)
}
