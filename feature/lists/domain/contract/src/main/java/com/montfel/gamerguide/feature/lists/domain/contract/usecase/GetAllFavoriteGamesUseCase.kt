package com.montfel.gamerguide.feature.lists.domain.contract.usecase

import com.montfel.gamerguide.feature.lists.domain.contract.model.FavoritedGame
import kotlinx.coroutines.flow.Flow

interface GetAllFavoriteGamesUseCase {
    suspend operator fun invoke(favoritedGame: FavoritedGame): Flow<List<FavoritedGame>>
}
