@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.montfel.data"
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
        }
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    implementation(projects.domain)

    implementation(platform(libs.firebase.bom))
    implementation(libs.bundles.firebase) //fixme

    implementation(libs.core)
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    implementation(platform(libs.okhttp.bom))
    implementation(libs.bundles.okhttp)
    implementation(libs.bundles.retrofit)

    testImplementation(libs.junit.test)
    androidTestImplementation(libs.junit.test.android)
    androidTestImplementation(libs.espresso)
}
