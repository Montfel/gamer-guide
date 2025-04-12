package com.montfel.gamerguide.feature.lists.domain.contract.usecase

interface ClearFavoriteGamesUseCase {
    suspend operator fun invoke(): Result<Unit>
}
