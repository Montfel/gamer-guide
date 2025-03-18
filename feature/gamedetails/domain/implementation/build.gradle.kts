plugins {
    alias(libs.plugins.gamerguide.kotlin.library)
}

dependencies {
    implementation(projects.feature.gamedetails.data.contract)
    implementation(projects.feature.gamedetails.domain.contract)
}
