package com.montfel.gamerguide.feature.gamedetails.domain.implementation.mapper

import com.montfel.gamerguide.feature.gamedetails.data.contract.model.PlatformData
import com.montfel.gamerguide.feature.gamedetails.domain.contract.model.Platform

fun PlatformData.toPlatform(): Platform {
    return Platform(
        id = id,
        name = name
    )
}
