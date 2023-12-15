package com.montfel.gamerguide.feature.data.datasource.remote.service

import com.montfel.gamerguide.feature.data.model.dto.GameDetailsDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GameService {
    @GET("games/{gameId}")
    suspend fun getGameDetails(
        @Path(value = "gameId") gameId: Int,
        @Query("key") apiKey: String
    ): GameDetailsDto
}
