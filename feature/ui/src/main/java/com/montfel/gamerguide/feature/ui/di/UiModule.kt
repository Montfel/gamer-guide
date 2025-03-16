package com.montfel.gamerguide.feature.ui.di

import org.koin.dsl.module
import com.montfel.gamerguide.feature.ui.gamedetails.GameDetailsViewModel
import com.montfel.gamerguide.feature.ui.home.HomeViewModel
import org.koin.core.module.dsl.viewModelOf

val uiModule = module {
    viewModelOf(::GameDetailsViewModel)
    viewModelOf(::HomeViewModel)
}
