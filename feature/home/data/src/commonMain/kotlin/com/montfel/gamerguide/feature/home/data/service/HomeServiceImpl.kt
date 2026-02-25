package com.montfel.gamerguide.feature.home.data.service

import com.montfel.gamerguide.core.network.http.HttpProvider
import com.montfel.gamerguide.feature.home.data.model.GamesData
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

internal class HomeServiceImpl(
    private val httpProvider: HttpProvider,
) : HomeService {
    override suspend fun getGames(query: String, page: Int, pageSize: Int): GamesData {
        val response = httpProvider().get(GAMES_PATH) {
            parameter(SEARCH, query)
            parameter(PAGE, page)
            parameter(PAGE_SIZE, pageSize)
        }

        return response.body<GamesData>()
    }

    private companion object {
        const val GAMES_PATH = "games"
        const val SEARCH = "search"
        const val PAGE = "page"
        const val PAGE_SIZE = "page_size"
    }
}
