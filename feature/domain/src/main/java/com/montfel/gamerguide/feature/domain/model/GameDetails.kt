package com.montfel.gamerguide.feature.domain.model

data class GameDetails(
    var name: String,
    var description: String,
    var released: String? = null,
    var backgroundImage: String? = null,
    var platforms: List<Platforms>? = emptyList(),
)
