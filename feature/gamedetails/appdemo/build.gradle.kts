plugins {
    alias(libs.plugins.gamerguide.android.application)
}

android {
    namespace = "${libs.versions.app.namespace.get()}.feature.gamedetails.appdemo"

    defaultConfig {
        applicationId = "${libs.versions.app.namespace.get()}.feature.gamedetails.appdemo"
    }
}

dependencies {
    implementation(projects.feature.gamedetails.ui)
}
