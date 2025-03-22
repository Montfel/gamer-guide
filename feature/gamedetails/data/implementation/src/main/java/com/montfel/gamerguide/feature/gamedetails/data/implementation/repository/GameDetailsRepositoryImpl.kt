package com.montfel.gamerguide.feature.gamedetails.data.implementation.repository

import com.montfel.gamerguide.core.common.ResultType
import com.montfel.gamerguide.feature.domain.model.GameDetails
import com.montfel.gamerguide.feature.domain.repository.GameDetailsRepository
import com.montfel.gamerguide.feature.gamedetails.data.implementation.datasource.remote.GameDetailsRemoteDataSource
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
