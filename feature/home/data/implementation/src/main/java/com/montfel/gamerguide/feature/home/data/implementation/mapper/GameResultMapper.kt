package com.montfel.gamerguide.feature.home.data.implementation.mapper

import com.montfel.gamerguide.feature.domain.model.Game
import com.montfel.gamerguide.feature.home.data.implementation.model.GameApi

internal fun GameApi.toGame() = Game(
    id = id,
    name = name,
    backgroundImage = backgroundImage,
)
