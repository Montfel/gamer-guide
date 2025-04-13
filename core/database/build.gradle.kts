plugins {
    alias(libs.plugins.ksp)
    alias(libs.plugins.kotlin.serialization)

    alias(libs.plugins.gamerguide.android.library)
}

android {
    namespace = "${libs.versions.app.namespace.get()}.core.database"
}

dependencies {
    // Room
    ksp(libs.room.compiler)
    implementation(libs.room.ktx)
    implementation(libs.room.runtime)

    // Koin
    implementation(platform(libs.koin.bom))
    implementation(libs.koin.core)

    implementation(libs.kotlin.serialization.json)
}
