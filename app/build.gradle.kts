plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
}

android {
    namespace = "com.montfel.gamerguide"
    compileSdk = rootProject.extra["compile_sdk"] as Int

    defaultConfig {
        applicationId = "com.montfel.gamerguide"
        minSdk = rootProject.extra["min_sdk"] as Int
        targetSdk = rootProject.extra["target_sdk"] as Int
        versionCode = 1
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = rootProject.extra["compose_compiler"] as String
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    val compose: String by rootProject.extra
    val material3: String by rootProject.extra
    val coil: String by rootProject.extra
    val accompanist: String by rootProject.extra
    val lifecycle: String by rootProject.extra
    val firebase: String by rootProject.extra
    val core: String by rootProject.extra
    val activity: String by rootProject.extra
    val navigation: String by rootProject.extra
    val junit: String by rootProject.extra

    // Modules
    implementation(project(":domain"))
    implementation(project(":common"))
    implementation(project(":core"))

    // Compose
    implementation("androidx.compose.animation:animation:$compose")
    implementation("androidx.compose.foundation:foundation:$compose")
    implementation("androidx.compose.runtime:runtime:$compose")
    implementation("androidx.compose.ui:ui:$compose")
    implementation("androidx.compose.ui:ui-tooling-preview:$compose")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$compose")
    debugImplementation("androidx.compose.ui:ui-tooling:$compose")
    debugImplementation("androidx.compose.ui:ui-test-manifest:$compose")

    // Material 3
    implementation("androidx.compose.material3:material3:$material3")

    // Coil
    implementation("io.coil-kt:coil-compose:$coil")

    // Accompanist
    implementation("com.google.accompanist:accompanist-systemuicontroller:$accompanist")

    // Lifecycle
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:$lifecycle")

    // Firebase
    implementation(platform("com.google.firebase:firebase-bom:$firebase"))
    implementation("com.google.firebase:firebase-analytics-ktx")
    implementation("com.google.firebase:firebase-crashlytics-ktx")

    // Dagger
    implementation("com.google.dagger:hilt-android:2.44")
    kapt("com.google.dagger:hilt-android-compiler:2.44")

    // Hilt
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")

    // Core
    implementation("androidx.core:core-ktx:$core")

    // Activity
    implementation("androidx.activity:activity-compose:$activity")

    // Navigation
    implementation("androidx.navigation:navigation-compose:$navigation")

    // Test
    testImplementation("junit:junit:$junit")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}
