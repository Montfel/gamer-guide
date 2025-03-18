plugins {
    alias(libs.plugins.gamerguide.android.application)
}

android {
    namespace = "${libs.versions.app.namespace.get()}.feature.home.appdemo"

    defaultConfig {
        applicationId = "${libs.versions.app.namespace.get()}.feature.home.appdemo"
    }
}

dependencies {
    implementation(projects.feature.home.ui)
}
