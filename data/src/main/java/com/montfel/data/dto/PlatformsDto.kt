package com.montfel.data.dto

import com.google.gson.annotations.SerializedName
import com.montfel.domain.model.Platforms

data class PlatformsDto(
    @SerializedName("platform")
    val platform: PlatformDto,

    @SerializedName("released_at")
    val releasedAt: String

) {
    fun toDomain() = Platforms(
        platform = platform.toDomain(),
        releasedAt = releasedAt
    )
}
