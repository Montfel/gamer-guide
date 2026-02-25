package com.montfel.gamerguide.feature.home.data.mapper

import com.montfel.gamerguide.feature.home.data.model.GameData
import com.montfel.gamerguide.feature.home.data.model.GamesData
import com.montfel.gamerguide.feature.home.domain.model.Games

internal fun GamesData.toGames() = Games(
    results = results.map(GameData::toGame),
)
