plugins {
    `kotlin-dsl`
    alias(libs.plugins.detekt)
    alias(libs.plugins.kover)
}

group = "com.montfel.gamerguide.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

dependencies {
    compileOnly(libs.android.tools)
    compileOnly(libs.detekt.gradlePlugin)
    compileOnly(libs.kotlin.gradle)
    compileOnly(libs.kover.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "gamerguide.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidLibrary") {
            id = "gamerguide.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "gamerguide.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("kotlinLibrary") {
            id = "gamerguide.kotlin.library"
            implementationClass = "KotlinLibraryConventionPlugin"
        }
    }
}
