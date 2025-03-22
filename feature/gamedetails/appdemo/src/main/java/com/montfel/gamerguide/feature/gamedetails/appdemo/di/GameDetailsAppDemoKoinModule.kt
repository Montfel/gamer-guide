package com.montfel.gamerguide.feature.gamedetails.appdemo.di

import com.montfel.gamerguide.feature.gamedetails.appdemo.buildconfig.ApplicationBuildConfigFieldsProvider
import com.montfel.gamerguide.core.common.buildconfig.BuildConfigFieldsProvider
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val gameDetailsAppDemoKoinModule = module {
    singleOf<BuildConfigFieldsProvider>(::ApplicationBuildConfigFieldsProvider)
}
