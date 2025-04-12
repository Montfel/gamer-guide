package com.montfel.gamerguide.feature.gamedetails.data.implementation.di

import com.montfel.gamerguide.feature.gamedetails.data.contract.repository.GameDetailsRepository
import com.montfel.gamerguide.feature.gamedetails.data.implementation.datasource.remote.GameDetailsRemoteDataSource
import com.montfel.gamerguide.feature.gamedetails.data.implementation.datasource.remote.GameDetailsRemoteDataSourceImpl
import com.montfel.gamerguide.feature.gamedetails.data.implementation.repository.GameDetailsRepositoryImpl
import com.montfel.gamerguide.feature.gamedetails.data.implementation.service.GameDetailsService
import com.montfel.gamerguide.feature.gamedetails.data.implementation.service.GameDetailsServiceImpl
import org.koin.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val gameDetailsDataModule = module {
    singleOf(::GameDetailsRepositoryImpl) bind GameDetailsRepository::class
    singleOf(::GameDetailsRemoteDataSourceImpl) bind GameDetailsRemoteDataSource::class
    singleOf(::GameDetailsServiceImpl) bind GameDetailsService::class
}
