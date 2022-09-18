package com.montfel.gamerguide.di

import com.montfel.gamerguide.data.repository.RepositoryImpl
import com.montfel.gamerguide.domain.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoriesModule {

    @Singleton
    @Binds
    internal abstract fun bindsRepository(
        repositoryImpl: RepositoryImpl
    ): Repository
}
