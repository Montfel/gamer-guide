package com.montfel.gamerguide.feature.data.mapper

import com.montfel.gamerguide.feature.data.model.dto.GameDetailsDto
import com.montfel.gamerguide.feature.data.model.dto.PlatformsDto
import com.montfel.gamerguide.feature.domain.model.GameDetails

internal fun GameDetailsDto.toGameDetails() = GameDetails(
    id = id,
    name = name,
    description = description,
    released = released,
    backgroundImage = backgroundImage,
    platforms = platforms.map(PlatformsDto::toPlatforms)
)
