import com.montfel.gamerguide.configureDetekt
import com.montfel.gamerguide.configureKotlinLibrary
import org.gradle.api.Plugin
import org.gradle.api.Project

class KotlinLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            configureKotlinLibrary()
            configureDetekt()
        }
    }
}
