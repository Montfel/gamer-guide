package com.montfel.gamerguide.feature.data.service

import com.montfel.gamerguide.feature.data.model.dto.GamesDto

interface GamesService {
    suspend fun getGames(page: Int, pageSize: Int): GamesDto
}
