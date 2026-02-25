plugins {
    alias(libs.plugins.android.library)

    alias(libs.plugins.gamerguide.kotlin.multiplatform)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(project.dependencies.platform(libs.koin.bom))
            implementation(libs.koin.core)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "com.montfel.gamerguide.feature.gamedetails.domain"
    compileSdk = libs.versions.android.sdk.compile.get().toInt()
}
