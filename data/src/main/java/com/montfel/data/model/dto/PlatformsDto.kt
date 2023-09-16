package com.montfel.data.model.dto

import com.google.gson.annotations.SerializedName

data class PlatformsDto(
    @SerializedName("platform")
    val platform: PlatformDto,

    @SerializedName("released_at")
    val releasedAt: String
)
