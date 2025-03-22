package com.montfel.gamerguide.feature.home.data.implementation.mapper

import com.montfel.gamerguide.feature.domain.model.Games
import com.montfel.gamerguide.feature.home.data.implementation.model.GameApi
import com.montfel.gamerguide.feature.home.data.implementation.model.GamesApi

internal fun GamesApi.toGames() = Games(
    results = results.map(GameApi::toGame),
)
