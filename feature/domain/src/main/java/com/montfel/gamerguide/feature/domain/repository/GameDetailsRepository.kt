package com.montfel.gamerguide.feature.domain.repository

import com.montfel.gamerguide.feature.domain.model.GameDetails
import com.montfel.util.Result

interface GameDetailsRepository {
    suspend fun getGameDetails(gameId: Int): Result<GameDetails>
}
