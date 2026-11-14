package com.montfel.gamerguide.feature.home.data.di

import com.montfel.gamerguide.feature.home.data.repository.HomeRepositoryImpl
import com.montfel.gamerguide.feature.home.data.service.HomeService
import com.montfel.gamerguide.feature.home.data.service.HomeServiceImpl
import com.montfel.gamerguide.feature.home.domain.repository.HomeRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val homeDataModule = module {
    singleOf(::HomeRepositoryImpl) bind HomeRepository::class
    singleOf(::HomeServiceImpl) bind HomeService::class
}
