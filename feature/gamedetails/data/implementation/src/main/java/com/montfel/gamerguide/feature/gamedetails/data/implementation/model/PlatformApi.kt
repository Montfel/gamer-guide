package com.montfel.gamerguide.feature.gamedetails.data.implementation.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlatformApi(
    @SerialName("id")
    val id: Int,

    @SerialName("name")
    val name: String? = null,
)
