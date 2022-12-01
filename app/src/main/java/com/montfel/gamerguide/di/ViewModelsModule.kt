package com.montfel.gamerguide.di

import com.montfel.gamerguide.presentation.gamedetails.GameDetailsViewModel
import com.montfel.gamerguide.presentation.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModels = module {
    viewModelOf(::GameDetailsViewModel)
    viewModelOf(::HomeViewModel)
}
