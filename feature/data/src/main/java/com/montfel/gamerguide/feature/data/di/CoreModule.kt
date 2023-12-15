package com.montfel.gamerguide.feature.data.di

import com.montfel.gamerguide.feature.data.datasource.remote.network.GameDetailsRemoteDataSource
import com.montfel.gamerguide.feature.data.datasource.remote.network.GameDetailsRemoteDataSourceImpl
import com.montfel.gamerguide.feature.data.repository.GameDetailsRepositoryImpl
import com.montfel.gamerguide.feature.domain.repository.GameDetailsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
internal abstract class CoreModule {

    @Binds
    abstract fun bindGameDetailsRepository(
        gameDetailsRepositoryImpl: GameDetailsRepositoryImpl
    ): GameDetailsRepository

    @Binds
    abstract fun bindGameDetailsRemoteDataSource(
        gameDetailsRemoteDataSourceImpl: GameDetailsRemoteDataSourceImpl
    ): GameDetailsRemoteDataSource
}
