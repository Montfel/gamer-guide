package com.montfel.gamerguide.feature.gamedetails.data.implementation.mapper

import com.montfel.gamerguide.feature.gamedetails.data.contract.model.PlatformsData
import com.montfel.gamerguide.feature.gamedetails.data.implementation.model.PlatformsApi

internal fun PlatformsApi.toPlatforms(): PlatformsData {
    return PlatformsData(
        platform = platform?.toPlatform(),
        releasedAt = releasedAt
    )
}
