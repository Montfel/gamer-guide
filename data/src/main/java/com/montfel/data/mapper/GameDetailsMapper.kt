package com.montfel.data.mapper

import com.montfel.data.model.dto.GameDetailsDto
import com.montfel.domain.model.GameDetails

internal fun GameDetailsDto.toDomain() = GameDetails(
    name = name,
    description = description,
    released = released,
    backgroundImage = backgroundImage,
    platforms = platforms.map { it.toDomain() }
)
