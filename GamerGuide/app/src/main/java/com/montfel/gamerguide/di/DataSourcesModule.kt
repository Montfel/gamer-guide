package com.montfel.gamerguide.di

import com.montfel.gamerguide.data.datasource.DataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DataSourcesModule {

    @Singleton
    @Provides
    fun providesProfileDataSource(retrofit: Retrofit): DataSource =
        retrofit.create(DataSource::class.java)
}
