package com.montfel.gamerguide.feature.gamedetails.data.implementation.service

import com.montfel.gamerguide.feature.gamedetails.data.implementation.model.GameDetailsApi

interface GameDetailsService {
    suspend fun getGameDetails(gameId: Int): GameDetailsApi
}
