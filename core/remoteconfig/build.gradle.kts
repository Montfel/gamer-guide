plugins {
    alias(libs.plugins.gamerguide.android.library)
}

android {
    namespace = "${libs.versions.app.namespace.get()}.core.remoteconfig"
}

dependencies {
    // Firebase
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.config)

    // Koin
    implementation(platform(libs.koin.bom))
    implementation(libs.koin.core)
}
