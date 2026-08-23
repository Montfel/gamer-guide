package com.montfel.gamerguide.feature.gamedetails.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class PlatformsData(
    @SerialName("platform")
    val platform: PlatformData? = null,

    @SerialName("released_at")
    val releasedAt: String? = null,
)
