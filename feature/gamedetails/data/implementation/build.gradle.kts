plugins {
    alias(libs.plugins.gamerguide.android.library)
}

android {
    namespace = "${libs.versions.app.namespace.get()}.feature.gamedetails.data.implementation"
}

dependencies {
    implementation(projects.feature.gamedetails.data.contract)
}
