import com.android.build.gradle.LibraryExtension
import com.montfel.gamerguide.configureCompose
import com.montfel.gamerguide.configureAndroidLibrary
import com.montfel.gamerguide.configureDetekt
import com.montfel.gamerguide.configureKover
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class ComposeLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            extensions.configure<LibraryExtension> {
                configureAndroidLibrary(this)
                configureCompose(this)
                configureDetekt()
                configureKover()
            }
        }
    }
}
