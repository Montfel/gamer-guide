package com.montfel.gamerguide.feature.home.domain.implementation.mapper

import com.montfel.gamerguide.feature.home.data.contract.model.GameData
import com.montfel.gamerguide.feature.home.domain.contract.model.Game

fun GameData.toGame(): Game {
    return Game(
        id = id,
        name = name,
        backgroundImage = backgroundImage
    )
}
