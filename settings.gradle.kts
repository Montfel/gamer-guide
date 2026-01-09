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

include(":androidApp")

include(":core:common")
include(":core:database")
include(":core:designsystem")
include(":core:navigation")
include(":core:network")
include(":core:remoteconfig")

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

include(":feature:lists:appdemo")
include(":feature:lists:data:contract")
include(":feature:lists:data:implementation")
include(":feature:lists:domain:contract")
include(":feature:lists:domain:implementation")
include(":feature:lists:ui")
include(":shared")
