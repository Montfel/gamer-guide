package com.montfel.gamerguide.feature.gamedetails.data.service

import com.montfel.gamerguide.core.network.http.HttpProvider
import com.montfel.gamerguide.feature.gamedetails.data.model.GameDetailsData
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.appendPathSegments

internal class GameDetailsServiceImpl(
    private val httpProvider: HttpProvider
) : GameDetailsService {
    override suspend fun getGameDetails(gameId: Int): GameDetailsData {
        val response = httpProvider().get(GAMES_PATH) {
            url {
                appendPathSegments(gameId.toString())
            }
        }

        return response.body<GameDetailsData>()
    }

    private companion object {
        const val GAMES_PATH = "games"
    }
}
