package com.montfel.data.di

import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import com.montfel.data.dataSource.remote.remoteConfig.RemoteConfig
import com.montfel.data.dataSource.remote.remoteConfig.RemoteConfigDataSource
import com.montfel.data.dataSource.remote.remoteConfig.RemoteConfigDataSourceImpl
import com.montfel.data.dataSource.remote.service.GameService
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
    fun provideGameService(retrofit: Retrofit): GameService {
        // fixme Tentar prover a API_KEY para o service
        return retrofit.create(GameService::class.java)
    }

    @Singleton
    @Provides
    fun provideFirebaseRemoteConfig(): FirebaseRemoteConfig {
        val remoteConfig: FirebaseRemoteConfig = Firebase.remoteConfig
        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = 120
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
