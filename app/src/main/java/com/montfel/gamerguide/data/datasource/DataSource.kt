package com.montfel.gamerguide.data.datasource

import com.montfel.gamerguide.data.dto.GameDetailsDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DataSource {
    @GET("games/{gameId}")
    suspend fun getGameDetails(
        @Path(value = "gameId") gameId: Int,
        @Query("key") apiKey: String = Constants.API_KEY
    ): GameDetailsDto
}
