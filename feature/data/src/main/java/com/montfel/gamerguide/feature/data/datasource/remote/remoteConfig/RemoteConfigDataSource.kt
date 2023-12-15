package com.montfel.gamerguide.feature.data.datasource.remote.remoteConfig

interface RemoteConfigDataSource {
    suspend fun init(): Boolean
    suspend fun getString(key: String): String
}
