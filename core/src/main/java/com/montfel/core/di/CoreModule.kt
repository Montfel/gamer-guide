package com.montfel.core.di

import com.montfel.data.dataSource.remote.network.GameRemoteDataSource
import com.montfel.data.dataSource.remote.network.GameRemoteDataSourceImpl
import com.montfel.data.repository.RepositoryImpl
import com.montfel.domain.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
internal abstract class CoreModule {

    @Binds
    abstract fun bindRepository(
        repositoryImpl: RepositoryImpl
    ): Repository

    @Binds
    abstract fun bindGameRemoteDataSource(
        gameRemoteDataSourceImpl: GameRemoteDataSourceImpl
    ): GameRemoteDataSource
}
