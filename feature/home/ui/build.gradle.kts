plugins {
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.compose.multiplatform)

    alias(libs.plugins.gamerguide.kotlin.multiplatform)
}

kotlin {
    android {
        namespace = "com.montfel.gamerguide.feature.home.ui"
        compileSdk = libs.versions.android.sdk.compile.get().toInt()
    }

    sourceSets {
        commonMain.dependencies {
            implementation(libs.compose.runtime)
            implementation(libs.compose.foundation)
            implementation(libs.compose.material3)
            implementation(libs.compose.ui)
            implementation(libs.compose.components.resources)
            implementation(libs.compose.ui.tooling.preview)
            implementation(libs.androidx.lifecycle.viewmodelCompose)
            implementation(libs.androidx.lifecycle.runtimeCompose)
            implementation(project.dependencies.platform(libs.koin.bom))
            implementation(libs.koin.compose)
            implementation(libs.koin.core)
            implementation(libs.bundles.coil)
            implementation(libs.paging.common)
            implementation(libs.paging.compose)

            implementation(projects.feature.home.domain)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}
