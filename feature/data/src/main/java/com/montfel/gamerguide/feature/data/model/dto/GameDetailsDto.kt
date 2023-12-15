package com.montfel.gamerguide.feature.data.model.dto

import com.google.gson.annotations.SerializedName

data class GameDetailsDto(
    @SerializedName("name")
    val name: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("released")
    val released: String,

    @SerializedName("background_image")
    val backgroundImage: String,

    @SerializedName("platforms")
    val platforms: List<PlatformsDto>
)
