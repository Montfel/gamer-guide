package com.montfel.gamerguide.feature.gamedetails.data.implementation.datasource.remote

import com.montfel.gamerguide.core.common.ResultType
import com.montfel.gamerguide.core.common.resultWrapper
import com.montfel.gamerguide.feature.domain.model.GameDetails
import com.montfel.gamerguide.feature.gamedetails.data.implementation.mapper.toGameDetails
import com.montfel.gamerguide.feature.gamedetails.data.implementation.service.GameDetailsService

class GameDetailsRemoteDataSourceImpl(
    private val service: GameDetailsService,
) : GameDetailsRemoteDataSource {
    override suspend fun getGameDetails(gameId: Int): ResultType<GameDetails> {
        return resultWrapper {
            service.getGameDetails(gameId = gameId).toGameDetails()
        }
    }
}
