package com.montfel.gamerguide.feature.gamedetails.domain.usecase

import com.montfel.gamerguide.feature.gamedetails.domain.model.GameDetails

interface GetGameDetailsUseCase {
    suspend operator fun invoke(gameId: Int): Result<GameDetails>
}
