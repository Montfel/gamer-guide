package com.montfel.gamerguide.feature.data.mapper

import com.montfel.gamerguide.feature.data.model.dto.GameDetailsDto
import com.montfel.gamerguide.feature.domain.model.GameDetails

internal fun GameDetailsDto.toDomain() = GameDetails(
    name = name,
    description = description,
    released = released,
    backgroundImage = backgroundImage,
    platforms = platforms.map { it.toDomain() }
)
