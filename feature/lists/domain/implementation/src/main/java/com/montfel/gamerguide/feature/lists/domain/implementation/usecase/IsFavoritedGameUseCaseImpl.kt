package com.montfel.gamerguide.feature.lists.domain.implementation.usecase

import com.montfel.gamerguide.feature.lists.data.contract.repository.ListsRepository
import com.montfel.gamerguide.feature.lists.domain.contract.usecase.IsFavoritedGameUseCase
import kotlinx.coroutines.flow.Flow

class IsFavoritedGameUseCaseImpl(
    private val repository: ListsRepository
) : IsFavoritedGameUseCase {
    override fun invoke(id: Int): Flow<Boolean> {
        return repository.isFavoritedGame(id)
    }
}
