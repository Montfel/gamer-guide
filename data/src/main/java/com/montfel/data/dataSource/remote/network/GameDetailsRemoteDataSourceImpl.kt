package com.montfel.data.dataSource.remote.network

import com.montfel.data.dataSource.remote.service.GameService
import com.montfel.data.mapper.toDomain
import com.montfel.domain.model.GameDetails
import javax.inject.Inject

class GameDetailsRemoteDataSourceImpl @Inject constructor(
    private val service: GameService
) : GameDetailsRemoteDataSource {
    override suspend fun getGameDetails(gameId: Int, apiKey: String): GameDetails {
        return service.getGameDetails(gameId = gameId, apiKey = apiKey).toDomain()
    }
}
