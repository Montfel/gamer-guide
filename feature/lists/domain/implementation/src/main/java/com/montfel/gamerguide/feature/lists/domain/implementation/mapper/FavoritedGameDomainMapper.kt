package com.montfel.gamerguide.feature.lists.domain.implementation.mapper

import com.montfel.gamerguide.feature.lists.data.contract.model.FavoritedGameData
import com.montfel.gamerguide.feature.lists.domain.contract.model.FavoritedGame

fun FavoritedGame.toFavoritedGameData(): FavoritedGameData {
    return FavoritedGameData(
        id = id,
        name = name,
        backgroundImage = backgroundImage
    )
}
