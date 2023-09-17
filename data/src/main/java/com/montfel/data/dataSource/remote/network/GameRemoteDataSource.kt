package com.montfel.data.dataSource.remote.network

import com.montfel.domain.model.GameDetails

interface GameRemoteDataSource {
    suspend fun getGameDetails(gameId: Int, apiKey: String): Result<GameDetails>
}
