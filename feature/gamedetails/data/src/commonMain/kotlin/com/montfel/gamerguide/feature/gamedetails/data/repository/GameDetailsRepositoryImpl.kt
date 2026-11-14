package com.montfel.gamerguide.feature.gamedetails.data.repository

import com.montfel.gamerguide.feature.gamedetails.data.mapper.toGameDetailsData
import com.montfel.gamerguide.feature.gamedetails.data.service.GameDetailsService
import com.montfel.gamerguide.feature.gamedetails.domain.model.GameDetails
import com.montfel.gamerguide.feature.gamedetails.domain.repository.GameDetailsRepository

internal class GameDetailsRepositoryImpl(
    private val service: GameDetailsService,
) : GameDetailsRepository {
    override suspend fun getGameDetails(gameId: Int): Result<GameDetails> {
        return runCatching {
            service.getGameDetails(gameId = gameId).toGameDetailsData()
        }
    }
}
