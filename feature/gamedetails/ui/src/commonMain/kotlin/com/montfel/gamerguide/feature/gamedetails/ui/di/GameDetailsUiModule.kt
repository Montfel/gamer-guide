package com.montfel.gamerguide.feature.gamedetails.ui.di

import com.montfel.gamerguide.feature.gamedetails.ui.GameDetailsViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val gameDetailsUiModule = module {
    viewModelOf(::GameDetailsViewModel)
}
