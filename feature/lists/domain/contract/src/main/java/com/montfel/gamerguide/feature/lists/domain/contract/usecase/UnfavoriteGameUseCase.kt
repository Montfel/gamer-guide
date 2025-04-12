package com.montfel.gamerguide.feature.lists.domain.contract.usecase

import com.montfel.gamerguide.feature.lists.domain.contract.model.FavoritedGame

interface UnfavoriteGameUseCase {
    suspend operator fun invoke(favoritedGame: FavoritedGame)
}
