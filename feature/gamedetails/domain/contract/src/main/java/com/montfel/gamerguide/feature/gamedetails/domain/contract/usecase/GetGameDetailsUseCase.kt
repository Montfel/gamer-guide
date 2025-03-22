package com.montfel.gamerguide.feature.gamedetails.domain.contract.usecase

import com.montfel.gamerguide.feature.gamedetails.domain.contract.model.GameDetails

interface GetGameDetailsUseCase {
    suspend operator fun invoke(gameId: Int): Result<GameDetails>
}
