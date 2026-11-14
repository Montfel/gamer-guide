plugins {
    alias(libs.plugins.kotlin.serialization)

    alias(libs.plugins.gamerguide.kotlin.multiplatform)
}

kotlin {
    android {
        namespace = "com.montfel.gamerguide.feature.home.data"
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
            implementation(libs.paging.common)

            implementation(projects.core.network)

            implementation(projects.feature.home.domain)
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}
