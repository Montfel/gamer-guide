package com.montfel.gamerguide.presentation

import com.montfel.gamerguide.presentation.gamedetail.GameDetailViewModel
import com.montfel.gamerguide.presentation.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModels = module {
    viewModelOf(::GameDetailViewModel)
    viewModelOf(::HomeViewModel)
}
