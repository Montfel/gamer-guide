package com.montfel.gamerguide.feature.gamedetails.data.contract.repository

import com.montfel.gamerguide.feature.gamedetails.data.contract.model.GameDetailsData

interface GameDetailsRepository {
    suspend fun getGameDetails(gameId: Int): Result<GameDetailsData>
}
