plugins {
    alias(libs.plugins.gamerguide.kotlin.multiplatform)
}

kotlin {
    android {
        namespace = "com.montfel.gamerguide.feature.home.domain"
        compileSdk = libs.versions.android.sdk.compile.get().toInt()
    }

    sourceSets {
        commonMain.dependencies {
            implementation(project.dependencies.platform(libs.koin.bom))
            implementation(libs.koin.core)
            implementation(libs.paging.common)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}
