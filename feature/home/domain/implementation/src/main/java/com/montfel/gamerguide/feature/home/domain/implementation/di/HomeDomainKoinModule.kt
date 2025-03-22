package com.montfel.gamerguide.feature.home.domain.implementation.di

import com.montfel.gamerguide.feature.home.domain.contract.usecase.GetGamesUseCase
import com.montfel.gamerguide.feature.home.domain.implementation.usecase.GetGamesUseCaseImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val homeDomainKoinModule = module {
    singleOf(::GetGamesUseCaseImpl) { bind<GetGamesUseCase>() }
}
