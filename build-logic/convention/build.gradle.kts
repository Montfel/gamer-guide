import org.gradle.accessors.dm.LibrariesForLibs

plugins {
    `kotlin-dsl`
}

group = "com.montfel.gamerguide.buildlogic"

dependencies {
    compileOnly(libs.gradle.plugin.android)
    compileOnly(libs.gradle.plugin.detekt)
    compileOnly(libs.gradle.plugin.kotlin)
    compileOnly(libs.gradle.plugin.kover)

    @Suppress("USELESS_CAST")
    implementation(
        files((libs as LibrariesForLibs).javaClass.superclass.protectionDomain.codeSource.location))
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = libs.plugins.gamerguide.android.application.get().pluginId
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidLibrary") {
            id = libs.plugins.gamerguide.android.library.get().pluginId
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = libs.plugins.gamerguide.compose.library.get().pluginId
            implementationClass = "ComposeLibraryConventionPlugin"
        }
        register("kotlinLibrary") {
            id = libs.plugins.gamerguide.kotlin.library.get().pluginId
            implementationClass = "KotlinLibraryConventionPlugin"
        }
    }
}
