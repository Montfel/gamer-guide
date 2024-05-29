package com.montfel.gamerguide

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project

internal fun configureAndroidCompose(
    commonExtension: CommonExtension<*, *, *, *, *, *>,
) {
    commonExtension.apply {
        buildFeatures {
            compose = true
        }
    }
}
