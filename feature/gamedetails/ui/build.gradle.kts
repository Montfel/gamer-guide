plugins {
    alias(libs.plugins.gamerguide.compose.library)
}

android {
    namespace = "${libs.versions.app.namespace.get()}.feature.gamedetails.ui"
}

dependencies {
}
