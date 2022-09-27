package com.montfel.domain.repository

import com.montfel.common.Response
import com.montfel.domain.model.GameDetails

interface Repository {
    suspend fun getGameDetails(gameId: Int): Response<GameDetails>
}
