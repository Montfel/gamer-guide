package com.montfel.gamerguide.feature.gamedetails.data.service

import com.montfel.gamerguide.feature.gamedetails.data.model.GameDetailsData

internal interface GameDetailsService {
    suspend fun getGameDetails(gameId: Int): GameDetailsData
}
