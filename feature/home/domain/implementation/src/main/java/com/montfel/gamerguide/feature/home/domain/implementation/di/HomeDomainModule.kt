package com.montfel.gamerguide.feature.home.domain.implementation.di

import com.montfel.gamerguide.feature.home.domain.contract.usecase.GetGamesUseCase
import com.montfel.gamerguide.feature.home.domain.implementation.usecase.GetGamesUseCaseImpl
import org.koin.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val homeDomainModule = module {
    singleOf(::GetGamesUseCaseImpl) bind GetGamesUseCase::class
}
