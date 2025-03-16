package com.montfel.gamerguide.di

import com.montfel.gamerguide.GamerGuideViewModel
import com.montfel.gamerguide.buildconfig.ApplicationBuildConfigFieldsProvider
import com.montfel.gamerguide.core.common.buildconfig.BuildConfigFieldsProvider
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    singleOf<BuildConfigFieldsProvider>(::ApplicationBuildConfigFieldsProvider)
    viewModelOf(::GamerGuideViewModel)
}
