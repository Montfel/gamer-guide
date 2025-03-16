package com.montfel.gamerguide.feature.data.mapper

import com.montfel.gamerguide.feature.data.model.dto.GameDto
import com.montfel.gamerguide.feature.domain.model.Game

internal fun GameDto.toGame() = Game(
    id = id,
    name = name,
    backgroundImage = backgroundImage,
)
