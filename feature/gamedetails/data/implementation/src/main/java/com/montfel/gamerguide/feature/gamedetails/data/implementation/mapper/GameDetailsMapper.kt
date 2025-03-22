package com.montfel.gamerguide.feature.gamedetails.data.implementation.mapper

import com.montfel.gamerguide.feature.domain.model.GameDetails
import com.montfel.gamerguide.feature.gamedetails.data.implementation.model.GameDetailsApi
import com.montfel.gamerguide.feature.gamedetails.data.implementation.model.PlatformsApi

internal fun GameDetailsApi.toGameDetails() = GameDetails(
    id = id,
    name = name,
    description = description,
    released = released,
    backgroundImage = backgroundImage,
    platforms = platforms.map(PlatformsApi::toPlatforms)
)
