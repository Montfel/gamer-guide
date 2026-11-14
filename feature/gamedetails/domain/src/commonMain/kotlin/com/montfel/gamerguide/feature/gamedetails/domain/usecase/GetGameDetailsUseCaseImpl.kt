package com.montfel.gamerguide.feature.gamedetails.domain.usecase

import com.montfel.gamerguide.feature.gamedetails.domain.model.GameDetails
import com.montfel.gamerguide.feature.gamedetails.domain.repository.GameDetailsRepository

internal class GetGameDetailsUseCaseImpl(
    private val gameDetailsRepository: GameDetailsRepository
) : GetGameDetailsUseCase {
    override suspend fun invoke(gameId: Int): Result<GameDetails> {
        return gameDetailsRepository.getGameDetails(gameId)
    }
}
