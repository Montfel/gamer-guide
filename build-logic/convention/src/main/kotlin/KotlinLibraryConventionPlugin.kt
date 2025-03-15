import com.montfel.gamerguide.applyKotlinPlugins
import com.montfel.gamerguide.configureDetekt
import com.montfel.gamerguide.configureKotlinLibrary
import com.montfel.gamerguide.configureKover
import org.gradle.api.Plugin
import org.gradle.api.Project

class KotlinLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            applyKotlinPlugins()

            configureKotlinLibrary()
            configureDetekt()
            configureKover()
        }
    }
}
