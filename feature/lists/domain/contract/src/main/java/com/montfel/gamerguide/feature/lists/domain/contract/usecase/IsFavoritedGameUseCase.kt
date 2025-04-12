package com.montfel.gamerguide.feature.lists.domain.contract.usecase

import kotlinx.coroutines.flow.Flow

interface IsFavoritedGameUseCase {
    suspend operator fun invoke(id: Int): Flow<Boolean>
}
