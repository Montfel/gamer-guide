package com.montfel.gamerguide.feature.lists.data.implementation.mapper

import com.montfel.gamerguide.core.database.model.entity.FavoritedGameEntity
import com.montfel.gamerguide.feature.lists.data.contract.model.FavoritedGameData

fun FavoritedGameData.toFavoritedGameEntity(): FavoritedGameEntity {
    return FavoritedGameEntity(
        id = id,
        name = name,
        backgroundImage = backgroundImage
    )
}

fun FavoritedGameEntity.toFavoritedGameData(): FavoritedGameData {
    return FavoritedGameData(
        id = id,
        name = name,
        backgroundImage = backgroundImage
    )
}
