package com.montfel.gamerguide.feature.gamedetails.data.mapper

import com.montfel.gamerguide.feature.gamedetails.data.model.PlatformsData
import com.montfel.gamerguide.feature.gamedetails.domain.model.Platforms

internal fun PlatformsData.toPlatforms(): Platforms {
    return Platforms(
        platform = platform?.toPlatform(),
        releasedAt = releasedAt
    )
}
