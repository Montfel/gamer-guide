@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id(libs.plugins.google.services.get().pluginId)
    id(libs.plugins.firebase.crashlytics.gradle.get().pluginId)
    alias(libs.plugins.ksp)
    id(libs.plugins.hilt.get().pluginId)
}

kotlin {
    sourceSets {
        debug {
            kotlin.srcDir("build/generated/ksp/debug/kotlin")
        }
        release {
            kotlin.srcDir("build/generated/ksp/release/kotlin")
        }
    }
}

android {
    namespace = "com.montfel.gamerguide"
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        applicationId = "com.montfel.gamerguide"
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
            isDebuggable = true
        }
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("debug")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    androidResources {
        generateLocaleConfig = true
    }
}

dependencies {

    implementation(projects.core.designsystem)
    implementation(projects.core.di)
    implementation(projects.data)
    implementation(projects.domain)
    implementation(projects.ui)

    implementation(libs.activity)
    implementation(libs.core)
    implementation(libs.destinations.core)
    ksp(libs.destinations.ksp)
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.analytics)
    implementation(libs.firebase.crashlytics)
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    implementation(libs.hilt.navigation)
    implementation(libs.bundles.lifecycle)
    implementation(libs.navigation)

    testImplementation(libs.junit.test)
    androidTestImplementation(libs.junit.test.android)
    androidTestImplementation(libs.espresso)
}
