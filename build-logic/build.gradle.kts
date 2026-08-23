import org.gradle.accessors.dm.LibrariesForLibs

plugins {
    `kotlin-dsl`
}

group = "com.montfel.gamerguide.buildlogic"

dependencies {
    compileOnly(libs.gradle.plugin.android)
    compileOnly(libs.gradle.plugin.kotlin)

    @Suppress("USELESS_CAST")
    implementation(
        files((libs as LibrariesForLibs).javaClass.superclass.protectionDomain.codeSource.location))
}

gradlePlugin {
    plugins {
        register("kotlinMultiplatform") {
            id = libs.plugins.gamerguide.kotlin.multiplatform.get().pluginId
            implementationClass = "KotlinMultiplatformConventionPlugin"
        }
    }
}
