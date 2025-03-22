package com.montfel.gamerguide.feature.gamedetails.domain.contract.model

data class GameDetails(
    val id: Int,
    val name: String?,
    val description: String?,
    val released: String?,
    val backgroundImage: String?,
    val platforms: List<Platforms>,
)
