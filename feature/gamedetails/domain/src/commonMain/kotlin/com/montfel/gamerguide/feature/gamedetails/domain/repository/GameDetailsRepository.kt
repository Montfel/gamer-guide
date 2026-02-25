package com.montfel.gamerguide.feature.gamedetails.domain.repository

import com.montfel.gamerguide.feature.gamedetails.domain.model.GameDetails

interface GameDetailsRepository {
    suspend fun getGameDetails(gameId: Int): Result<GameDetails>
}
