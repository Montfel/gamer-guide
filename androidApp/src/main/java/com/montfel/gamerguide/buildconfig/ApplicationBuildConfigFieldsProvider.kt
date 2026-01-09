package com.montfel.gamerguide.buildconfig

import com.montfel.gamerguide.BuildConfig
import com.montfel.gamerguide.core.common.buildconfig.BuildConfigFields
import com.montfel.gamerguide.core.common.buildconfig.BuildConfigFieldsProvider

class ApplicationBuildConfigFieldsProvider : BuildConfigFieldsProvider {
    override operator fun invoke(): BuildConfigFields = BuildConfigFields(
        isDebug = BuildConfig.DEBUG,
        versionCode = BuildConfig.VERSION_CODE,
        versionName = BuildConfig.VERSION_NAME,
        baseUrl = BuildConfig.BASE_URL
    )
}
