package com.montfel.gamerguide.feature.lists.domain.implementation.usecase

import com.montfel.gamerguide.feature.lists.data.contract.model.FavoritedGameData
import com.montfel.gamerguide.feature.lists.data.contract.repository.ListsRepository
import com.montfel.gamerguide.feature.lists.domain.contract.model.FavoritedGame
import com.montfel.gamerguide.feature.lists.domain.contract.usecase.GetAllFavoritedGamesUseCase
import com.montfel.gamerguide.feature.lists.domain.implementation.mapper.toFavoritedGame
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetAllFavoritedGamesUseCaseImpl(
    private val repository: ListsRepository
) : GetAllFavoritedGamesUseCase {
    override fun invoke(): Flow<List<FavoritedGame>> {
        return repository.getAllFavoritedGames().map { it.map(FavoritedGameData::toFavoritedGame) }
    }
}
