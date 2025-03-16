package com.montfel.gamerguide.feature.data.repository

import com.montfel.gamerguide.core.common.ResultType
import com.montfel.gamerguide.feature.data.datasource.remote.network.GameDetailsRemoteDataSource
import com.montfel.gamerguide.feature.domain.model.GameDetails
import com.montfel.gamerguide.feature.domain.repository.GameDetailsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GameDetailsRepositoryImpl(
    private val gameDetailsRemoteDataSource: GameDetailsRemoteDataSource,
) : GameDetailsRepository {
    override suspend fun getGameDetails(gameId: Int): ResultType<GameDetails> {
        return withContext(Dispatchers.IO) {
            gameDetailsRemoteDataSource.getGameDetails(gameId = gameId)
        }
    }
}
