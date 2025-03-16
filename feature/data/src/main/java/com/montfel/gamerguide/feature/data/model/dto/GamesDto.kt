package com.montfel.gamerguide.feature.data.model.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GamesDto(
    @SerialName("results")
    val results: List<GameDto>,
)
