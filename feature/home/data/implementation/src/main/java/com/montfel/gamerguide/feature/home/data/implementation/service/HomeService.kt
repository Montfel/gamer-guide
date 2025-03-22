package com.montfel.gamerguide.feature.home.data.implementation.service

import com.montfel.gamerguide.feature.home.data.implementation.model.GamesApi

interface HomeService {
    suspend fun getGames(page: Int, pageSize: Int): GamesApi
}
