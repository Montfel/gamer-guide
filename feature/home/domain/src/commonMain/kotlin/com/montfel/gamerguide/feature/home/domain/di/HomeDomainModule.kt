package com.montfel.gamerguide.feature.home.domain.di

import com.montfel.gamerguide.feature.home.domain.usecase.GetGamesUseCase
import com.montfel.gamerguide.feature.home.domain.usecase.GetGamesUseCaseImpl
import org.koin.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val homeDomainModule = module {
    singleOf(::GetGamesUseCaseImpl) bind GetGamesUseCase::class
}
