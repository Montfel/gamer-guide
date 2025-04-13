package com.montfel.gamerguide.feature.lists.domain.implementation.usecase

import com.montfel.gamerguide.feature.lists.domain.contract.model.FavoritedGame
import com.montfel.gamerguide.feature.lists.domain.contract.usecase.FavoriteGameUseCase
import com.montfel.gamerguide.feature.lists.data.contract.repository.ListsRepository
import com.montfel.gamerguide.feature.lists.domain.implementation.mapper.toFavoritedGameData

class FavoriteGameUseCaseImpl(
    private val repository: ListsRepository
): FavoriteGameUseCase {
    override suspend fun invoke(favoritedGame: FavoritedGame) {
        repository.favoriteGame(favoritedGame.toFavoritedGameData())
    }
}
