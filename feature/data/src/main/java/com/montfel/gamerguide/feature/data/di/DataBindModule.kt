package com.montfel.gamerguide.feature.data.di

import com.montfel.gamerguide.feature.data.datasource.remote.network.GameDetailsRemoteDataSource
import com.montfel.gamerguide.feature.data.datasource.remote.network.GameDetailsRemoteDataSourceImpl
import com.montfel.gamerguide.feature.data.datasource.remote.service.GameDetailsService
import com.montfel.gamerguide.feature.data.datasource.remote.service.GameDetailsServiceImpl
import com.montfel.gamerguide.feature.data.interceptor.HttpProvider
import com.montfel.gamerguide.feature.data.interceptor.HttpProviderImpl
import com.montfel.gamerguide.feature.data.repository.GameDetailsRepositoryImpl
import com.montfel.gamerguide.feature.domain.repository.GameDetailsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class DataBindModule {

    @Binds
    abstract fun bindGameDetailsRepository(
        gameDetailsRepositoryImpl: GameDetailsRepositoryImpl
    ): GameDetailsRepository

    @Binds
    abstract fun bindGameDetailsRemoteDataSource(
        gameDetailsRemoteDataSourceImpl: GameDetailsRemoteDataSourceImpl
    ): GameDetailsRemoteDataSource

    @Binds
    abstract fun bindHttpProvider(
        httpProviderImpl: HttpProviderImpl
    ): HttpProvider

    @Binds
    abstract fun bindGameDetailsService(
        gameDetailsServiceImpl: GameDetailsServiceImpl
    ): GameDetailsService
}
