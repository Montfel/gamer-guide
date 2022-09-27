package com.montfel.domain.model

data class GameDetails(
    var name: String,
    var description: String,
    var released: String? = null,
    var backgroundImage: String? = null,
    var platforms: List<Platforms>? = emptyList(),
)
