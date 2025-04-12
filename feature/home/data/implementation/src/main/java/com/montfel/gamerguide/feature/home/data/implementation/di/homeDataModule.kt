package com.montfel.gamerguide.feature.home.data.implementation.di

import com.montfel.gamerguide.feature.home.data.contract.repository.HomeRepository
import com.montfel.gamerguide.feature.home.data.implementation.datasource.remote.HomeRemoteDataSource
import com.montfel.gamerguide.feature.home.data.implementation.datasource.remote.HomeRemoteDataSourceImpl
import com.montfel.gamerguide.feature.home.data.implementation.repository.HomeRepositoryImpl
import com.montfel.gamerguide.feature.home.data.implementation.service.HomeService
import com.montfel.gamerguide.feature.home.data.implementation.service.HomeServiceImpl
import org.koin.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val homeDataModule = module {
    singleOf(::HomeRemoteDataSourceImpl) bind HomeRemoteDataSource::class
    singleOf(::HomeRepositoryImpl) bind HomeRepository::class
    singleOf(::HomeServiceImpl) bind HomeService::class
}
