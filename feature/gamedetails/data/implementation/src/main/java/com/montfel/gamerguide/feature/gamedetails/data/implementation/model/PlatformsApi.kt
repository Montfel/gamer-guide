package com.montfel.gamerguide.feature.gamedetails.data.implementation.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlatformsApi(
    @SerialName("platform")
    val platform: PlatformApi? = null,

    @SerialName("released_at")
    val releasedAt: String? = null,
)
