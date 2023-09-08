package com.montfel.data.mapper

import com.montfel.data.dto.PlatformDto
import com.montfel.domain.model.Platform

internal fun PlatformDto.toDomain() = Platform(
    id = id,
    name = name
)