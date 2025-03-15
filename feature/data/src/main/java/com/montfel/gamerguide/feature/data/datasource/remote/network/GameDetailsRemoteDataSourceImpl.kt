package com.montfel.gamerguide.feature.data.datasource.remote.network

import com.montfel.gamerguide.core.common.ResultType
import com.montfel.gamerguide.core.common.resultWrapper
import com.montfel.gamerguide.feature.data.datasource.remote.service.GameDetailsService
import com.montfel.gamerguide.feature.data.mapper.toDomain
import com.montfel.gamerguide.feature.domain.model.GameDetails
import javax.inject.Inject

class GameDetailsRemoteDataSourceImpl @Inject constructor(
    private val service: GameDetailsService,
) : GameDetailsRemoteDataSource {
    override suspend fun getGameDetails(gameId: Int): ResultType<GameDetails> {
        return resultWrapper {
            service.getGameDetails(gameId = gameId).toDomain()
        }
    }
}
