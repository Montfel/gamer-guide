package com.montfel.gamerguide.feature.data.datasource.remote.network

import com.montfel.gamerguide.feature.domain.model.GameDetails

interface GameDetailsRemoteDataSource {
    suspend fun getGameDetails(gameId: Int, apiKey: String): GameDetails
}
