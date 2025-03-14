package com.montfel.gamerguide

import com.android.build.api.dsl.CommonExtension

internal fun configureCompose(
    commonExtension: CommonExtension<*, *, *, *, *, *>,
) {
    commonExtension.apply {
        buildFeatures {
            compose = true
        }
    }
}
