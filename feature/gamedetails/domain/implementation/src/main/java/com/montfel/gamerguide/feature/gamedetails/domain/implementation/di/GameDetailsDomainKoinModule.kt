package com.montfel.gamerguide.feature.gamedetails.domain.implementation.di

import com.montfel.gamerguide.feature.gamedetails.domain.contract.usecase.GetGameDetailsUseCase
import com.montfel.gamerguide.feature.gamedetails.domain.implementation.usecase.GetGameDetailsUseCaseImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val gameDetailsDomainKoinModule = module {
    singleOf(::GetGameDetailsUseCaseImpl) { bind<GetGameDetailsUseCase>() }
}
