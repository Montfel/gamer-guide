package com.montfel.data.dataSource.remote.network

import com.montfel.domain.model.GameDetails

interface GameDetailsRemoteDataSource {
    suspend fun getGameDetails(gameId: Int, apiKey: String): GameDetails
}
