package com.montfel.data.mapper

import com.montfel.data.dto.PlatformsDto
import com.montfel.domain.model.Platforms

fun PlatformsDto.toDomain() = Platforms(
    platform = platform.toDomain(),
    releasedAt = releasedAt
)