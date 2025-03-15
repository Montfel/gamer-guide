package com.montfel.gamerguide.feature.data.di

import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.analytics
import com.google.firebase.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.remoteConfig
import com.google.firebase.remoteconfig.remoteConfigSettings
import com.montfel.gamerguide.feature.data.datasource.remote.remoteConfig.RemoteConfig
import com.montfel.gamerguide.feature.data.datasource.remote.remoteConfig.RemoteConfigDataSource
import com.montfel.gamerguide.feature.data.datasource.remote.remoteConfig.RemoteConfigDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

private const val MINIMUM_FETCH_INTERVAL_IN_SECONDS = 120L

@Module
@InstallIn(SingletonComponent::class)
internal object DataProvideModule {

    @Singleton
    @Provides
    fun provideFirebaseAnalytics(): FirebaseAnalytics = Firebase.analytics

    @Singleton
    @Provides
    fun provideFirebaseRemoteConfig(): FirebaseRemoteConfig {
        val remoteConfig: FirebaseRemoteConfig = Firebase.remoteConfig
        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = MINIMUM_FETCH_INTERVAL_IN_SECONDS
        }
        remoteConfig.setConfigSettingsAsync(configSettings)
        remoteConfig.setDefaultsAsync(RemoteConfig.defaults)

        return remoteConfig
    }

    @Provides
    @Singleton
    fun provideFirebaseRemoteConfigProvider(remoteConfig: FirebaseRemoteConfig): RemoteConfigDataSource {
        return RemoteConfigDataSourceImpl(remoteConfig)
    }
}
