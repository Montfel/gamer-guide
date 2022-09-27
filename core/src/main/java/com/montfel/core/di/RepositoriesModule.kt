package com.montfel.core.di

import com.montfel.data.repository.RepositoryImpl
import com.montfel.domain.repository.Repository
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
