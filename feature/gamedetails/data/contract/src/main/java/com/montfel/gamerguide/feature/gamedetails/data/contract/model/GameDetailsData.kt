package com.montfel.gamerguide.feature.gamedetails.data.contract.model

data class GameDetailsData(
    val id: Int,
    val name: String?,
    val description: String?,
    val released: String?,
    val backgroundImage: String?,
    val platforms: List<PlatformsData>,
)
