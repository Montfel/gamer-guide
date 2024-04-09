package com.montfel.gamerguide

import com.android.build.gradle.BaseExtension
import kotlinx.kover.gradle.plugin.dsl.KoverDefaultReportsConfig
import kotlinx.kover.gradle.plugin.dsl.KoverReportExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

private const val ANDROID = "android"
private const val KOVER = "kover"
private const val MIN_BOUND_VALUE = 0

private val Project.android: BaseExtension? get() = extensions.findByName(ANDROID) as? BaseExtension

internal fun Project.configureKover() {
    configureKoverDefaults {
        val buildTypes = android?.buildTypes?.map { type -> type.name } ?: emptyList()

        verify {
            rule {
                isEnabled = true
                bound {
                    minValue = MIN_BOUND_VALUE
                }
                buildTypes.forEach { mergeWith(it) }
            }
        }
    }
}

private fun Project.configureKoverDefaults(
    additionalConfig: KoverDefaultReportsConfig.() -> Unit = {}
) {
    pluginManager.apply(libs.findPlugin(KOVER).get().get().pluginId)

    extensions.getByType<KoverReportExtension>().apply {
        defaults {
            filters {
                excludes {
                    packages("*.di", "*.dto", "*.model", "*.mapper", "*.util", "*.contract")
                }

                includes {
                    classes("*.*ViewModel")
                    packages("*.domain", "*.data")
                }
            }

            additionalConfig()
        }
    }
}

internal fun Project.configureKoverForRootProject() {
    configureKoverDefaults()

    dependencies {
        subprojects
            .filter { project -> project.subprojects.isEmpty() }
            .forEach { project -> add(KOVER, project) }
    }
}
