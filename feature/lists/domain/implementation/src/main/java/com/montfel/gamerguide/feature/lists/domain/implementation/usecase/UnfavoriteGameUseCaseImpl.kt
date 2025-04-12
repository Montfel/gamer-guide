package com.montfel.gamerguide.feature.lists.domain.implementation.usecase

import com.montfel.gamerguide.feature.lists.data.contract.repository.ListsRepository
import com.montfel.gamerguide.feature.lists.domain.contract.model.FavoritedGame
import com.montfel.gamerguide.feature.lists.domain.contract.usecase.UnfavoriteGameUseCase
import com.montfel.gamerguide.feature.lists.domain.implementation.mapper.toFavoritedGameData

class UnfavoriteGameUseCaseImpl(
    private val repository: ListsRepository
): UnfavoriteGameUseCase {
    override suspend fun invoke(favoritedGame: FavoritedGame) {
        repository.unfavoriteGame(favoritedGame.toFavoritedGameData())
    }
}
