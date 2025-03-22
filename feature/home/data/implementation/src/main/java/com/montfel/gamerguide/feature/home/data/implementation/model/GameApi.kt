package com.montfel.gamerguide.feature.home.data.implementation.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GameApi(
    @SerialName("id")
    val id: Int,

    @SerialName("name")
    val name: String? = null,

    @SerialName("background_image")
    val backgroundImage: String? = null,
)
