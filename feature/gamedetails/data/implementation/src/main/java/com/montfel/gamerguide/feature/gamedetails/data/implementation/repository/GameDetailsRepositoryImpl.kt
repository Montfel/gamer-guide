package com.montfel.gamerguide.feature.gamedetails.data.implementation.repository

import com.montfel.gamerguide.feature.gamedetails.data.contract.model.GameDetailsData
import com.montfel.gamerguide.feature.gamedetails.data.contract.repository.GameDetailsRepository
import com.montfel.gamerguide.feature.gamedetails.data.implementation.datasource.remote.GameDetailsRemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GameDetailsRepositoryImpl(
    private val gameDetailsRemoteDataSource: GameDetailsRemoteDataSource,
) : GameDetailsRepository {
    override suspend fun getGameDetails(gameId: Int): Result<GameDetailsData> {
        return withContext(Dispatchers.IO) {
            gameDetailsRemoteDataSource.getGameDetails(gameId = gameId)
        }
    }
}
