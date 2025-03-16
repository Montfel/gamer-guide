package com.montfel.gamerguide.feature.data.mapper

import com.montfel.gamerguide.feature.data.model.dto.GameDto
import com.montfel.gamerguide.feature.data.model.dto.GamesDto
import com.montfel.gamerguide.feature.domain.model.Games

internal fun GamesDto.toGames() = Games(
    results = results.map(GameDto::toGame),
)
