pluginManagement {
    includeBuild("build-logic")

    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "GamerGuide"

include(":app")

include(":core:common")
include(":core:designsystem")

include(":feature:data")
include(":feature:domain")
include(":feature:ui")

include(":feature:gamedetails:appdemo")
include(":feature:gamedetails:data:contract")
include(":feature:gamedetails:data:implementation")
include(":feature:gamedetails:domain:contract")
include(":feature:gamedetails:domain:implementation")
include(":feature:gamedetails:ui")

include(":feature:home:appdemo")
include(":feature:home:data:contract")
include(":feature:home:data:implementation")
include(":feature:home:domain:contract")
include(":feature:home:domain:implementation")
include(":feature:home:ui")
