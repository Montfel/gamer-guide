package com.montfel.gamerguide.feature.data.model.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GameDetailsDto(
    @SerialName("name")
    val name: String,

    @SerialName("description")
    val description: String,

    @SerialName("released")
    val released: String,

    @SerialName("background_image")
    val backgroundImage: String,

    @SerialName("platforms")
    val platforms: List<PlatformsDto>
)
