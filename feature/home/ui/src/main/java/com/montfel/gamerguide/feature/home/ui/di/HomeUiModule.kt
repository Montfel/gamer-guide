package com.montfel.gamerguide.feature.home.ui.di

import org.koin.dsl.module
import com.montfel.gamerguide.feature.home.ui.HomeViewModel
import org.koin.core.module.dsl.viewModelOf

val homeUiModule = module {
    viewModelOf(::HomeViewModel)
}
