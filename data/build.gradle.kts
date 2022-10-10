plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.montfel.data"
    compileSdk = rootProject.extra["compile_sdk"] as Int

    defaultConfig {
        minSdk = rootProject.extra["min_sdk"] as Int
        targetSdk = rootProject.extra["target_sdk"] as Int

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {

    val core: String by rootProject.extra
    val retrofit: String by rootProject.extra
    val activity: String by rootProject.extra
    val junit: String by rootProject.extra

    // Modules
    implementation(project(":common"))
    implementation(project(":domain"))

    // Dagger
    implementation("com.google.dagger:hilt-android:2.44")
    kapt("com.google.dagger:hilt-android-compiler:2.44")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:$retrofit")
    implementation("com.google.code.gson:gson:$retrofit")
    implementation("com.squareup.retrofit2:converter-gson:$retrofit")

    // Hilt
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")

    // Core
    implementation("androidx.core:core-ktx:$core")

    // Test
    testImplementation("junit:junit:$junit")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}
