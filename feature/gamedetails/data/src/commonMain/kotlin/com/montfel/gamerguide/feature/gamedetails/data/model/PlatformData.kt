package com.montfel.gamerguide.feature.gamedetails.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class PlatformData(
    @SerialName("id")
    val id: Int,

    @SerialName("name")
    val name: String? = null,
)
