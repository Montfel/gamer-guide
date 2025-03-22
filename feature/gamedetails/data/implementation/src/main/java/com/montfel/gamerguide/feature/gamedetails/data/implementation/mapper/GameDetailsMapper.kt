package com.montfel.gamerguide.feature.gamedetails.data.implementation.mapper

import com.montfel.gamerguide.feature.gamedetails.data.contract.model.GameDetailsData
import com.montfel.gamerguide.feature.gamedetails.data.implementation.model.GameDetailsApi
import com.montfel.gamerguide.feature.gamedetails.data.implementation.model.PlatformsApi

internal fun GameDetailsApi.toGameDetailsData(): GameDetailsData {
    return GameDetailsData(
        id = id,
        name = name,
        description = description,
        released = released,
        backgroundImage = backgroundImage,
        platforms = platforms.map(PlatformsApi::toPlatforms)
    )
}
