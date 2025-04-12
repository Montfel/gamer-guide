package com.montfel.gamerguide.feature.lists.domain.contract.usecase

import com.montfel.gamerguide.feature.lists.domain.contract.model.FavoritedGame

interface FavoriteGameUseCase {
    suspend operator fun invoke(favoritedGame: FavoritedGame)
}
