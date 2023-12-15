package com.montfel.gamerguide.feature.domain.repository

import com.montfel.gamerguide.core.common.Result
import com.montfel.gamerguide.feature.domain.model.GameDetails

interface GameDetailsRepository {
    suspend fun getGameDetails(gameId: Int): Result<GameDetails>
}
