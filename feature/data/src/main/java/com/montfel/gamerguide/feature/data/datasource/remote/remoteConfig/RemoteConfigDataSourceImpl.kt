package com.montfel.gamerguide.feature.data.datasource.remote.remoteConfig

import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import javax.inject.Inject
import kotlinx.coroutines.tasks.await

internal class RemoteConfigDataSourceImpl @Inject constructor(
    private val firebaseRemoteConfig: FirebaseRemoteConfig,
) : RemoteConfigDataSource {
    override suspend fun init(): Boolean = firebaseRemoteConfig.fetchAndActivate().await()

    override suspend fun getString(key: String): String {
        return firebaseRemoteConfig.getString(key)
    }
}
