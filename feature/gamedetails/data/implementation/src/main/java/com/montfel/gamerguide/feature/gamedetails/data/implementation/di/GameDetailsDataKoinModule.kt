package com.montfel.gamerguide.feature.gamedetails.data.implementation.di

import com.montfel.gamerguide.feature.domain.repository.GameDetailsRepository
import com.montfel.gamerguide.feature.gamedetails.data.implementation.datasource.remote.GameDetailsRemoteDataSource
import com.montfel.gamerguide.feature.gamedetails.data.implementation.datasource.remote.GameDetailsRemoteDataSourceImpl
import com.montfel.gamerguide.feature.gamedetails.data.implementation.repository.GameDetailsRepositoryImpl
import com.montfel.gamerguide.feature.gamedetails.data.implementation.service.GameDetailsService
import com.montfel.gamerguide.feature.gamedetails.data.implementation.service.GameDetailsServiceImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val gameDetailsDataKoinModule = module {
    singleOf(::GameDetailsRepositoryImpl) { bind<GameDetailsRepository>() }
    singleOf(::GameDetailsRemoteDataSourceImpl) { bind<GameDetailsRemoteDataSource>() }
    singleOf(::GameDetailsServiceImpl) { bind<GameDetailsService>() }
}
