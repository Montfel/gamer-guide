package com.montfel.gamerguide.domain.repository

import com.montfel.gamerguide.domain.model.GameDetails
import com.montfel.gamerguide.helper.Response

interface Repository {
    suspend fun getGameDetails(gameId: Int, apiKey: String): Response<GameDetails>
}
