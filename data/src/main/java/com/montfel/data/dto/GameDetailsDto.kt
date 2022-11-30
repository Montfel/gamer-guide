package com.montfel.data.dto

import com.google.gson.annotations.SerializedName
import com.montfel.domain.model.GameDetails

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
) {
    fun toDomain() = GameDetails(
        name = name,
        description = description,
        released = released,
        backgroundImage = backgroundImage,
        platforms = platforms.map { it.toDomain() }
    )
}
