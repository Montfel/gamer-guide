package com.montfel.gamerguide.feature.gamedetails.domain.model

data class GameDetails(
    val id: Int,
    val name: String?,
    val description: String?,
    val released: String?,
    val backgroundImage: String?,
    val platforms: List<Platforms>,
)
