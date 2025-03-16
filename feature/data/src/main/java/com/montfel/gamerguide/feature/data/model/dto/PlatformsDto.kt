package com.montfel.gamerguide.feature.data.model.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlatformsDto(
    @SerialName("platform")
    val platform: PlatformDto? = null,

    @SerialName("released_at")
    val releasedAt: String? = null,
)
