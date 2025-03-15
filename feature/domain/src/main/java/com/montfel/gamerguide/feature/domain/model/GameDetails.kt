package com.montfel.gamerguide.feature.domain.model

data class GameDetails(
    var name: String,
    var description: String,
    var released: String,
    var backgroundImage: String,
    var platforms: List<Platforms>,
)
