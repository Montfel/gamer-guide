package com.montfel.gamerguide.feature.home.data.implementation.mapper

import com.montfel.gamerguide.feature.home.data.contract.model.GameData
import com.montfel.gamerguide.feature.home.data.implementation.model.GameApi

internal fun GameApi.toGameData() = GameData(
    id = id,
    name = name,
    backgroundImage = backgroundImage,
)
