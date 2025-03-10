plugins {
    `kotlin-dsl`
}

group = "com.montfel.gamerguide.buildlogic"

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
