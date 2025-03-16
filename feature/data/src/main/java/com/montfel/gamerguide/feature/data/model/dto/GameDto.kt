package com.montfel.gamerguide.feature.data.model.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GameDto(
    @SerialName("id")
    val id: Int,

    @SerialName("name")
    val name: String? = null,

    @SerialName("background_image")
    val backgroundImage: String? = null,
)
