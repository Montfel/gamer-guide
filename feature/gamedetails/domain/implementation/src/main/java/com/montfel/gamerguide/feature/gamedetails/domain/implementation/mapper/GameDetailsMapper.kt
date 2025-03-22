package com.montfel.gamerguide.feature.gamedetails.domain.implementation.mapper

import com.montfel.gamerguide.feature.gamedetails.data.contract.model.GameDetailsData
import com.montfel.gamerguide.feature.gamedetails.data.contract.model.PlatformsData
import com.montfel.gamerguide.feature.gamedetails.domain.contract.model.GameDetails

fun GameDetailsData.toGameDetails(): GameDetails {
    return GameDetails(
        id = id,
        name = name,
        description = description,
        released = released,
        backgroundImage = backgroundImage,
        platforms = platforms.map(PlatformsData::toPlatforms)
    )
}
