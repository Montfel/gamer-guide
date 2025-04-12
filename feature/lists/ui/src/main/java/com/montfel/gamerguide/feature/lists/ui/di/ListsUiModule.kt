package com.montfel.gamerguide.feature.lists.ui.di

import com.montfel.gamerguide.feature.lists.ui.ListsViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val listsUiModule = module {
    viewModelOf(::ListsViewModel)
}
