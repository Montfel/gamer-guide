package com.montfel.gamerguide.feature.home.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class GamesData(
    @SerialName("results")
    val results: List<GameData>,
)
