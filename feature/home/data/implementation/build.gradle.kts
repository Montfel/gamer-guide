plugins {
    alias(libs.plugins.gamerguide.android.library)
}

android {
    namespace = "${libs.versions.app.namespace.get()}.feature.home.data.implementation"
}

dependencies {
    implementation(projects.feature.home.data.contract)
}
