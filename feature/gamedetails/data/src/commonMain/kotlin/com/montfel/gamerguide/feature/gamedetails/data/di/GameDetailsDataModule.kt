package com.montfel.gamerguide.feature.gamedetails.data.di

import com.montfel.gamerguide.feature.gamedetails.data.repository.GameDetailsRepositoryImpl
import com.montfel.gamerguide.feature.gamedetails.data.service.GameDetailsService
import com.montfel.gamerguide.feature.gamedetails.data.service.GameDetailsServiceImpl
import com.montfel.gamerguide.feature.gamedetails.domain.repository.GameDetailsRepository
import org.koin.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val gameDetailsDataModule = module {
    singleOf(::GameDetailsRepositoryImpl) bind GameDetailsRepository::class
    singleOf(::GameDetailsServiceImpl) bind GameDetailsService::class
}
