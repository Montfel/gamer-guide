package com.montfel.gamerguide.feature.data.service

import com.montfel.gamerguide.feature.data.model.dto.GameDetailsDto

interface GameDetailsService {
    suspend fun getGameDetails(gameId: Int): GameDetailsDto
}
