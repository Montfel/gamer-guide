package com.montfel.gamerguide.feature.data.mapper

import com.montfel.gamerguide.feature.data.model.dto.PlatformsDto
import com.montfel.gamerguide.feature.domain.model.Platforms

internal fun PlatformsDto.toDomain() = Platforms(
    platform = platform.toDomain(),
    releasedAt = releasedAt
)
