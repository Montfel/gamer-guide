package com.montfel.data.datasource

import com.montfel.data.dto.GameDetailsDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GameService {
    @GET("games/{gameId}")
    suspend fun getGameDetails(
        @Path(value = "gameId") gameId: Int,
        @Query("key") apiKey: String = Constants.API_KEY
    ): GameDetailsDto
}