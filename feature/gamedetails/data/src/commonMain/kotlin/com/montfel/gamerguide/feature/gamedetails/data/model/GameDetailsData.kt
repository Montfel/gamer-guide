package com.montfel.gamerguide.feature.gamedetails.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class GameDetailsData(
    @SerialName("id")
    val id: Int,

    @SerialName("name")
    val name: String? = null,

    @SerialName("description")
    val description: String? = null,

    @SerialName("released")
    val released: String? = null,

    @SerialName("background_image")
    val backgroundImage: String? = null,

    @SerialName("platforms")
    val platforms: List<PlatformsData>,
)
