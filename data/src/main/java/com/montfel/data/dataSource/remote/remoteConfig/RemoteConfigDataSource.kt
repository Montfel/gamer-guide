package com.montfel.data.dataSource.remote.remoteConfig

interface RemoteConfigDataSource {
    suspend fun init(): Boolean
    suspend fun getString(key: String): String

    companion object {
        const val API_KEY = "api_key"
    }
}