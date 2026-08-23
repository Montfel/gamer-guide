package com.montfel.gamerguide.feature.home.data.service

import com.montfel.gamerguide.feature.home.data.model.GamesData

internal interface HomeService {
    suspend fun getGames(query: String, page: Int, pageSize: Int): GamesData
}
