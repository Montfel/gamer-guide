package com.montfel.gamerguide.feature.lists.domain.contract.usecase

import com.montfel.gamerguide.feature.lists.domain.contract.model.FavoritedGame
import kotlinx.coroutines.flow.Flow

interface GetAllFavoritedGamesUseCase {
    operator fun invoke(): Flow<List<FavoritedGame>>
}
