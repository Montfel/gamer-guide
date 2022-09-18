package com.montfel.gamerguide.data.dto

import com.google.gson.annotations.SerializedName
import com.montfel.gamerguide.data.DtoMapper
import com.montfel.gamerguide.domain.model.Platforms

data class PlatformsDto(
    @SerializedName("platform")
    val platform: PlatformDto,

    @SerializedName("released_at")
    val releasedAt: String

) : DtoMapper<Platforms> {
    override fun toDomain() = Platforms(
        platform = platform.toDomain(),
        releasedAt = releasedAt
    )
}
