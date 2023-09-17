package com.montfel.core.di

import com.montfel.data.dataSource.remote.network.GameDetailsRemoteDataSource
import com.montfel.data.dataSource.remote.network.GameDetailsRemoteDataSourceImpl
import com.montfel.data.repository.GameDetailsRepositoryImpl
import com.montfel.domain.repository.GameDetailsRepository
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
