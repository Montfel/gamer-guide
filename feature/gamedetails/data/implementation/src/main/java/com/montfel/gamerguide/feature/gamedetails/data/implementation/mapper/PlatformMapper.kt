package com.montfel.gamerguide.feature.gamedetails.data.implementation.mapper

import com.montfel.gamerguide.feature.gamedetails.data.contract.model.PlatformData
import com.montfel.gamerguide.feature.gamedetails.data.implementation.model.PlatformApi

internal fun PlatformApi.toPlatform(): PlatformData {
    return PlatformData(
        id = id,
        name = name
    )
}
