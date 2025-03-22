package com.montfel.gamerguide.feature.gamedetails.domain.implementation.mapper

import com.montfel.gamerguide.feature.gamedetails.data.contract.model.PlatformsData
import com.montfel.gamerguide.feature.gamedetails.domain.contract.model.Platforms

fun PlatformsData.toPlatforms(): Platforms {
    return Platforms(
        platform = platform?.toPlatform(),
        releasedAt = releasedAt
    )
}
