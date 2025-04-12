package com.montfel.gamerguide.feature.gamedetails.ui.mapper

import com.montfel.gamerguide.feature.gamedetails.domain.contract.model.GameDetails
import com.montfel.gamerguide.feature.lists.domain.contract.model.FavoritedGame

fun GameDetails.toFavoritedGame(): FavoritedGame {
    return FavoritedGame(
        id = id,
        name = name,
        backgroundImage = backgroundImage,
    )
}
