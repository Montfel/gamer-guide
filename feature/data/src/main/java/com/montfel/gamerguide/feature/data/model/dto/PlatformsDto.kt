package com.montfel.gamerguide.feature.data.model.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlatformsDto(
    @SerialName("platform")
    val platform: PlatformDto,

    @SerialName("released_at")
    val releasedAt: String? = null,
)
