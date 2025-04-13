plugins {
    alias(libs.plugins.kotlin.serialization)

    alias(libs.plugins.gamerguide.android.library)
}

android {
    namespace = "${libs.versions.app.namespace.get()}.feature.lists.data.implementation"
}

dependencies {
    implementation(projects.core.common)
    implementation(projects.core.database)
    implementation(projects.core.network)

    implementation(projects.feature.lists.data.contract)

    // Koin
    implementation(platform(libs.koin.bom))
    implementation(libs.koin.core)

    // Kotlin Serialization
    implementation(libs.kotlin.serialization.json)

    implementation(libs.kotlin.coroutines.core)
}
