package com.montfel.data.mapper

import com.montfel.data.dto.PlatformsDto
import com.montfel.domain.model.Platforms

internal fun PlatformsDto.toDomain() = Platforms(
    platform = platform.toDomain(),
    releasedAt = releasedAt
)