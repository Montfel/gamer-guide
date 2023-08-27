package com.montfel.di

import com.montfel.data.datasource.GameService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {

    @Singleton
    @Provides
    fun provideGameService(retrofit: Retrofit): GameService =
        retrofit.create(GameService::class.java)
}