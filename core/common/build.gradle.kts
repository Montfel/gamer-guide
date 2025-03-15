plugins {
    alias(libs.plugins.kotlin.jvm)

    alias(libs.plugins.gamerguide.kotlin.library)
}

dependencies {
    implementation(libs.ktor.client.core)
}
