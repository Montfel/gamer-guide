package com.montfel.gamerguide.feature.gamedetails.data.mapper

import com.montfel.gamerguide.feature.gamedetails.data.model.PlatformData
import com.montfel.gamerguide.feature.gamedetails.domain.model.Platform

internal fun PlatformData.toPlatform(): Platform {
    return Platform(
        id = id,
        name = name
    )
}
