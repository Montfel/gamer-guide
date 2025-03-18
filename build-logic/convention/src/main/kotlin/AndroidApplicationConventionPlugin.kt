import com.android.build.api.dsl.ApplicationExtension
import com.montfel.gamerguide.applyAndroidApplicationPlugins
import com.montfel.gamerguide.applyComposePlugins
import com.montfel.gamerguide.configureAndroidApplication
import com.montfel.gamerguide.configureCompose
import com.montfel.gamerguide.configureDetekt
import com.montfel.gamerguide.configureKover
import com.montfel.gamerguide.configureKoverForRootProject
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target.rootProject) { configureKoverForRootProject() }
        with(target) {
            applyAndroidApplicationPlugins()
            applyComposePlugins()

            extensions.configure<ApplicationExtension> {
                configureAndroidApplication(this)
                configureCompose(this)
                configureDetekt()
                configureKover()
            }
        }
    }
}
