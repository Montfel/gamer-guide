plugins {
    alias(libs.plugins.kotlin.serialization)

    alias(libs.plugins.gamerguide.kotlin.multiplatform)
}

kotlin {
    android {
        namespace = "com.montfel.gamerguide.feature.gamedetails.data"
        compileSdk = libs.versions.android.sdk.compile.get().toInt()
    }

    sourceSets {
        androidMain.dependencies {
            implementation(libs.ktor.client.okhttp)
        }
        commonMain.dependencies {
            implementation(project.dependencies.platform(libs.koin.bom))
            implementation(libs.koin.core)
            implementation(libs.bundles.ktor)

            implementation(projects.core.network)

            implementation(projects.feature.gamedetails.domain)
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}
