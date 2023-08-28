package com.montfel.data.mapper

import com.montfel.data.dto.GameDetailsDto
import com.montfel.domain.model.GameDetails

fun GameDetailsDto.toDomain() = GameDetails(
    name = name,
    description = description,
    released = released,
    backgroundImage = backgroundImage,
    platforms = platforms.map { it.toDomain() }
)