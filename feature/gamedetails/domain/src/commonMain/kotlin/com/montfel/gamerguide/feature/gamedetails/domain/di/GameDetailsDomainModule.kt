package com.montfel.gamerguide.feature.gamedetails.domain.di

import com.montfel.gamerguide.feature.gamedetails.domain.usecase.GetGameDetailsUseCase
import com.montfel.gamerguide.feature.gamedetails.domain.usecase.GetGameDetailsUseCaseImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val gameDetailsDomainModule = module {
    singleOf(::GetGameDetailsUseCaseImpl) bind GetGameDetailsUseCase::class
}
