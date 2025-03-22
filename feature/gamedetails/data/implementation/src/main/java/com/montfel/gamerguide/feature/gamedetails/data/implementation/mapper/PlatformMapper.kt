package com.montfel.gamerguide.feature.gamedetails.data.implementation.mapper

import com.montfel.gamerguide.feature.domain.model.Platform
import com.montfel.gamerguide.feature.gamedetails.data.implementation.model.PlatformApi

internal fun PlatformApi.toPlatform() = Platform(
    id = id,
    name = name
)
