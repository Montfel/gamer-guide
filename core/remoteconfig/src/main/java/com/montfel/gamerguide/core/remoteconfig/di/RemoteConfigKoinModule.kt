package com.montfel.gamerguide.core.remoteconfig.di

import com.google.firebase.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.remoteConfig
import com.google.firebase.remoteconfig.remoteConfigSettings
import com.montfel.gamerguide.core.remoteconfig.remoteconfig.RemoteConfig
import com.montfel.gamerguide.core.remoteconfig.remoteconfig.RemoteConfigDataSource
import com.montfel.gamerguide.core.remoteconfig.remoteconfig.RemoteConfigDataSourceImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

private const val MINIMUM_FETCH_INTERVAL_IN_SECONDS = 120L

val remoteConfigKoinModule = module {
    singleOf(::RemoteConfigDataSourceImpl) { bind<RemoteConfigDataSource>() }
    single<FirebaseRemoteConfig> {
        val remoteConfig: FirebaseRemoteConfig = Firebase.remoteConfig
        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = MINIMUM_FETCH_INTERVAL_IN_SECONDS
        }
        remoteConfig.setConfigSettingsAsync(configSettings)
        remoteConfig.setDefaultsAsync(RemoteConfig.defaults)

        remoteConfig
    }
}
