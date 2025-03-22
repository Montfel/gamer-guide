package com.montfel.gamerguide.feature.gamedetails.data.implementation.datasource.remote

import com.montfel.gamerguide.feature.gamedetails.data.contract.model.GameDetailsData
import com.montfel.gamerguide.feature.gamedetails.data.implementation.mapper.toGameDetailsData
import com.montfel.gamerguide.feature.gamedetails.data.implementation.service.GameDetailsService

class GameDetailsRemoteDataSourceImpl(
    private val service: GameDetailsService,
) : GameDetailsRemoteDataSource {
    override suspend fun getGameDetails(gameId: Int): Result<GameDetailsData> {
        return runCatching {
            service.getGameDetails(gameId = gameId).toGameDetailsData()
        }
    }
}
