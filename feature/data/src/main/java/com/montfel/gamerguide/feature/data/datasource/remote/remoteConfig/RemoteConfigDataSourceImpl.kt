package com.montfel.gamerguide.feature.data.datasource.remote.remoteConfig

import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

internal class RemoteConfigDataSourceImpl @Inject constructor(
    private val firebaseRemoteConfig: FirebaseRemoteConfig,
) : RemoteConfigDataSource {
    override suspend fun init(): Boolean {
        return suspendCoroutine { continuation ->
            firebaseRemoteConfig.fetchAndActivate().addOnCompleteListener {
                if (it.isComplete && it.isSuccessful) {
                    continuation.resume(it.result)
                } else {
                    continuation.resume(false)
                }
            }
        }
    }

    override suspend fun getString(key: String): String {
        return firebaseRemoteConfig.getString(key)
    }
}
