rootProject.name = "GamerGuide"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    includeBuild("build-logic")

    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

include(":androidApp")
include(":shared")

include(":core:network")

include(":feature:home:domain")
include(":feature:home:data")

include(":feature:home:ui")
include(":feature:gamedetails:data")
include(":feature:gamedetails:domain")
include(":feature:gamedetails:ui")
