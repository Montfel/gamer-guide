package com.montfel.gamerguide.feature.data.mapper

import com.montfel.gamerguide.feature.data.model.dto.PlatformDto
import com.montfel.gamerguide.feature.domain.model.Platform

internal fun PlatformDto.toDomain() = Platform(
    id = id,
    name = name
)
