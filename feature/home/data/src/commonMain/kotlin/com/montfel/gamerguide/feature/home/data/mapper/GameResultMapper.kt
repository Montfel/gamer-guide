package com.montfel.gamerguide.feature.home.data.mapper

import com.montfel.gamerguide.feature.home.data.model.GameData
import com.montfel.gamerguide.feature.home.domain.model.Game

internal fun GameData.toGame() = Game(
    id = id,
    name = name,
    backgroundImage = backgroundImage,
)
