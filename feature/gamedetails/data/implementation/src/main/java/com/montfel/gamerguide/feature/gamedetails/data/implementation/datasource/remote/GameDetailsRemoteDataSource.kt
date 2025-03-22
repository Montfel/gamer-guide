package com.montfel.gamerguide.feature.gamedetails.data.implementation.datasource.remote

import com.montfel.gamerguide.feature.gamedetails.data.contract.model.GameDetailsData

interface GameDetailsRemoteDataSource {
    suspend fun getGameDetails(gameId: Int): Result<GameDetailsData>
}
