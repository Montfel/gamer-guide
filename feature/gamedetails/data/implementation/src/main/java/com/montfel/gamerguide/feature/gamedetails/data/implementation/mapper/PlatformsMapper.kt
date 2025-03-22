package com.montfel.gamerguide.feature.gamedetails.data.implementation.mapper

import com.montfel.gamerguide.feature.domain.model.Platforms
import com.montfel.gamerguide.feature.gamedetails.data.implementation.model.PlatformsApi

internal fun PlatformsApi.toPlatforms() = Platforms(
    platform = platform?.toPlatform(),
    releasedAt = releasedAt
)
