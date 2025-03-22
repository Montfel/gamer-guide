package com.montfel.gamerguide.core.remoteconfig.remoteconfig

import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

internal class RemoteConfigDataSourceImpl(
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
