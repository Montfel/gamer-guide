package com.montfel.gamerguide.di

import com.montfel.gamerguide.buildconfig.ApplicationBuildConfigFieldsProvider
import com.montfel.gamerguide.core.common.buildconfig.BuildConfigFieldsProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class AppModule {

    @Binds
    abstract fun bindApplicationBuildConfigFieldsProvider(
        applicationBuildConfigFieldsProvider: ApplicationBuildConfigFieldsProvider
    ): BuildConfigFieldsProvider
}
