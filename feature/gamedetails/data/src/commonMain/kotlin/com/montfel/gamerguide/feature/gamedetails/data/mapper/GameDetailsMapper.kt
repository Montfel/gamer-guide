package com.montfel.gamerguide.feature.gamedetails.data.mapper

import com.montfel.gamerguide.feature.gamedetails.data.model.GameDetailsData
import com.montfel.gamerguide.feature.gamedetails.data.model.PlatformsData
import com.montfel.gamerguide.feature.gamedetails.domain.model.GameDetails

internal fun GameDetailsData.toGameDetailsData(): GameDetails {
    return GameDetails(
        id = id,
        name = name,
        description = description,
        released = released,
        backgroundImage = backgroundImage,
        platforms = platforms.map(PlatformsData::toPlatforms)
    )
}
