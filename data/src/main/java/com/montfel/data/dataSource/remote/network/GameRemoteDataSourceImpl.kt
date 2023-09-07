package com.montfel.data.dataSource.remote.network

import com.montfel.data.dataSource.remote.service.GameService
import com.montfel.data.mapper.toDomain
import com.montfel.domain.model.GameDetails
import javax.inject.Inject

class GameRemoteDataSourceImpl @Inject constructor(
    private val service: GameService
) : GameRemoteDataSource {
    override suspend fun getGameDetails(gameId: Int, apiKey: String): Result<GameDetails> {
        return runCatching {
            Result.success(service.getGameDetails(gameId = gameId, apiKey = apiKey).toDomain())
        }.getOrElse {
            it.printStackTrace()
            Result.failure(it)
        }
    }
}