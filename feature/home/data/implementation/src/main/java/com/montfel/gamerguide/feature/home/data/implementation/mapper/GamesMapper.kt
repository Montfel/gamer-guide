package com.montfel.gamerguide.feature.home.data.implementation.mapper

import com.montfel.gamerguide.feature.home.data.contract.model.GamesData
import com.montfel.gamerguide.feature.home.data.implementation.model.GameApi
import com.montfel.gamerguide.feature.home.data.implementation.model.GamesApi

internal fun GamesApi.toGames() = GamesData(
    results = results.map(GameApi::toGameData),
)
