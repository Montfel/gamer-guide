package com.montfel.domain.repository

import com.montfel.domain.helper.Result
import com.montfel.domain.model.GameDetails

interface GameDetailsRepository {
    suspend fun getGameDetails(gameId: Int): Result<GameDetails>
}
