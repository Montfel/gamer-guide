package com.montfel.gamerguide.feature.gamedetails.domain.implementation.usecase

import com.montfel.gamerguide.feature.gamedetails.data.contract.model.GameDetailsData
import com.montfel.gamerguide.feature.gamedetails.data.contract.repository.GameDetailsRepository
import com.montfel.gamerguide.feature.gamedetails.domain.contract.model.GameDetails
import com.montfel.gamerguide.feature.gamedetails.domain.contract.usecase.GetGameDetailsUseCase
import com.montfel.gamerguide.feature.gamedetails.domain.implementation.mapper.toGameDetails

class GetGameDetailsUseCaseImpl(
    private val gameDetailsRepository: GameDetailsRepository
) : GetGameDetailsUseCase {
    override suspend fun invoke(gameId: Int): Result<GameDetails> {
        return gameDetailsRepository.getGameDetails(gameId).map(GameDetailsData::toGameDetails)
    }
}
