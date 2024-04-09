import com.android.build.api.dsl.ApplicationExtension
import com.montfel.gamerguide.configureAndroidApplication
import com.montfel.gamerguide.configureAndroidCompose
import com.montfel.gamerguide.configureDetekt
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            extensions.configure<ApplicationExtension> {
                configureAndroidApplication(this)
                configureAndroidCompose(this)
                configureDetekt()
            }
        }
    }
}
