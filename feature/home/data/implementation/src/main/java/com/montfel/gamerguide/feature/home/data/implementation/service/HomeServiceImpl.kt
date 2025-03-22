package com.montfel.gamerguide.feature.home.data.implementation.service

import com.montfel.gamerguide.core.common.buildconfig.BuildConfigFieldsProvider
import com.montfel.gamerguide.core.network.interceptor.HttpProvider
import com.montfel.gamerguide.feature.home.data.implementation.model.GamesApi
import io.ktor.client.call.body
import io.ktor.client.request.get

internal class HomeServiceImpl(
    private val httpProvider: HttpProvider,
    private val buildConfigFieldsProvider: BuildConfigFieldsProvider,
) : HomeService {
    override suspend fun getGames(page: Int, pageSize: Int): GamesApi {
        val buildConfigFields = buildConfigFieldsProvider()
        val baseUrl = buildConfigFields.baseUrl
        val url = baseUrl.plus(GAMES_PATH)
        val client = httpProvider()

        val response = client.get(url) {
            url {
                parameters.append(PAGE, page.toString())
                parameters.append(PAGE_SIZE, pageSize.toString())
                parameters.append(ORDERING, "released")
            }
        }

        return response.body<GamesApi>()
    }

    private companion object {
        const val GAMES_PATH = "games"
        const val PAGE = "page"
        const val PAGE_SIZE = "page_size"
        const val ORDERING = "ordering"
    }
}
