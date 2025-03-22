package com.montfel.gamerguide.feature.gamedetails.data.implementation.datasource.remote

import com.montfel.gamerguide.core.common.ResultType
import com.montfel.gamerguide.feature.domain.model.GameDetails

interface GameDetailsRemoteDataSource {
    suspend fun getGameDetails(gameId: Int): ResultType<GameDetails>
}
