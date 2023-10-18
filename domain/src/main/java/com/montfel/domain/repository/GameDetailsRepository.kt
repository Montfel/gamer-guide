package com.montfel.domain.repository

import com.montfel.domain.model.GameDetails
import com.montfel.util.Result

interface GameDetailsRepository {
    suspend fun getGameDetails(gameId: Int): Result<GameDetails>
}
