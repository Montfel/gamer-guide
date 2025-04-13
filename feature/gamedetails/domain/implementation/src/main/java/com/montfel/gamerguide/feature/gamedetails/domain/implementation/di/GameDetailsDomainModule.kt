package com.montfel.gamerguide.feature.gamedetails.domain.implementation.di

import com.montfel.gamerguide.feature.gamedetails.domain.contract.usecase.GetGameDetailsUseCase
import com.montfel.gamerguide.feature.gamedetails.domain.implementation.usecase.GetGameDetailsUseCaseImpl
import org.koin.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val gameDetailsDomainModule = module {
    singleOf(::GetGameDetailsUseCaseImpl) bind GetGameDetailsUseCase::class
}
