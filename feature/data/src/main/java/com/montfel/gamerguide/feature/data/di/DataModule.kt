package com.montfel.gamerguide.feature.data.di

import com.google.firebase.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.remoteConfig
import com.google.firebase.remoteconfig.remoteConfigSettings
import com.montfel.gamerguide.feature.data.datasource.remote.network.GameDetailsRemoteDataSource
import com.montfel.gamerguide.feature.data.datasource.remote.network.GameDetailsRemoteDataSourceImpl
import com.montfel.gamerguide.feature.data.datasource.remote.remoteConfig.RemoteConfig
import com.montfel.gamerguide.feature.data.datasource.remote.remoteConfig.RemoteConfigDataSource
import com.montfel.gamerguide.feature.data.datasource.remote.remoteConfig.RemoteConfigDataSourceImpl
import com.montfel.gamerguide.feature.data.datasource.remote.service.GameDetailsService
import com.montfel.gamerguide.feature.data.datasource.remote.service.GameDetailsServiceImpl
import com.montfel.gamerguide.feature.data.interceptor.HttpProvider
import com.montfel.gamerguide.feature.data.interceptor.HttpProviderImpl
import com.montfel.gamerguide.feature.data.repository.GameDetailsRepositoryImpl
import com.montfel.gamerguide.feature.domain.repository.GameDetailsRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

private const val MINIMUM_FETCH_INTERVAL_IN_SECONDS = 120L

val dataModule = module {
    singleOf(::GameDetailsRepositoryImpl) { bind<GameDetailsRepository>() }
    singleOf(::GameDetailsRemoteDataSourceImpl) { bind<GameDetailsRemoteDataSource>() }
    singleOf(::HttpProviderImpl) { bind<HttpProvider>() }
    singleOf(::GameDetailsServiceImpl) { bind<GameDetailsService>() }
    single<FirebaseRemoteConfig> {
        val remoteConfig: FirebaseRemoteConfig = Firebase.remoteConfig
        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = MINIMUM_FETCH_INTERVAL_IN_SECONDS
        }
        remoteConfig.setConfigSettingsAsync(configSettings)
        remoteConfig.setDefaultsAsync(RemoteConfig.defaults)

        remoteConfig
    }
    singleOf(::RemoteConfigDataSourceImpl) { bind<RemoteConfigDataSource>() }
}
