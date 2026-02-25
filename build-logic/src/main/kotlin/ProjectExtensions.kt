import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.the

val Project.libs
    get() = the<LibrariesForLibs>()

internal fun Project.applyKotlinMultiplatformPlugins() {
    apply(plugin = libs.plugins.kotlin.multiplatform.get().pluginId)
}
