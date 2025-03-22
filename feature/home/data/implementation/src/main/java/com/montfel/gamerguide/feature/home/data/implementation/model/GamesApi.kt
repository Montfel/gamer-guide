package com.montfel.gamerguide.feature.home.data.implementation.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GamesApi(
    @SerialName("results")
    val results: List<GameApi>,
)
