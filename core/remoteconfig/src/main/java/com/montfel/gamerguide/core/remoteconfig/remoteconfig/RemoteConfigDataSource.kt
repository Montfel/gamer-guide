package com.montfel.gamerguide.core.remoteconfig.remoteconfig

interface RemoteConfigDataSource {
    suspend fun init(): Boolean
    suspend fun getString(key: String): String
}
