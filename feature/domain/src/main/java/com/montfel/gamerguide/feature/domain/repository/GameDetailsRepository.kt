package com.montfel.gamerguide.feature.domain.repository

import com.montfel.gamerguide.core.common.ResultType
import com.montfel.gamerguide.feature.domain.model.GameDetails

interface GameDetailsRepository {
    suspend fun getGameDetails(gameId: Int): ResultType<GameDetails>
}
