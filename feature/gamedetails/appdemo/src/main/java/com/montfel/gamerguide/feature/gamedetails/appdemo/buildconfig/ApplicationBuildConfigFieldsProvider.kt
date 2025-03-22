package com.montfel.gamerguide.feature.gamedetails.appdemo.buildconfig

import com.montfel.gamerguide.core.common.buildconfig.BuildConfigFields
import com.montfel.gamerguide.core.common.buildconfig.BuildConfigFieldsProvider
import com.montfel.gamerguide.feature.gamedetails.appdemo.BuildConfig

class ApplicationBuildConfigFieldsProvider : BuildConfigFieldsProvider {
    override operator fun invoke(): BuildConfigFields = BuildConfigFields(
        isDebug = BuildConfig.DEBUG,
        versionCode = BuildConfig.VERSION_CODE,
        versionName = BuildConfig.VERSION_NAME,
        baseUrl = BuildConfig.BASE_URL
    )
}
