plugins {
    alias(libs.plugins.kotlin.serialization)

    alias(libs.plugins.gamerguide.kotlin.multiplatform)
}

kotlin {
    android {
        namespace = "com.montfel.gamerguide.core.network"
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
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}
