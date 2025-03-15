package com.montfel.gamerguide.feature.data.model.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlatformDto(
    @SerialName("id")
    val id: Int,

    @SerialName("name")
    val name: String
)
