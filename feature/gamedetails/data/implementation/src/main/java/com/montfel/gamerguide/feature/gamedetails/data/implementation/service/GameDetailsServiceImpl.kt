package com.montfel.gamerguide.feature.gamedetails.data.implementation.service

import com.montfel.gamerguide.core.common.buildconfig.BuildConfigFieldsProvider
import com.montfel.gamerguide.core.network.interceptor.HttpProvider
import com.montfel.gamerguide.feature.gamedetails.data.implementation.model.GameDetailsApi
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.appendPathSegments

internal class GameDetailsServiceImpl(
    private val httpProvider: HttpProvider,
    private val buildConfigFieldsProvider: BuildConfigFieldsProvider,
) : GameDetailsService {
    override suspend fun getGameDetails(gameId: Int): GameDetailsApi {
        val buildConfigFields = buildConfigFieldsProvider()
        val baseUrl = buildConfigFields.baseUrl
        val url = baseUrl.plus(GAMES_PATH)
        val client = httpProvider()

        val response = client.get(url) {
            url {
                appendPathSegments(gameId.toString())
            }
        }

        return response.body<GameDetailsApi>()
    }

    private companion object {
        const val GAMES_PATH = "games"
    }
}
