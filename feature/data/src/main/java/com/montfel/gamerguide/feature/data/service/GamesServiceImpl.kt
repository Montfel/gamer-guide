package com.montfel.gamerguide.feature.data.service

import com.montfel.gamerguide.core.common.buildconfig.BuildConfigFieldsProvider
import com.montfel.gamerguide.feature.data.interceptor.HttpProvider
import com.montfel.gamerguide.feature.data.model.dto.GamesDto
import io.ktor.client.call.body
import io.ktor.client.request.get

internal class GamesServiceImpl(
    private val httpProvider: HttpProvider,
    private val buildConfigFieldsProvider: BuildConfigFieldsProvider,
) : GamesService {
    override suspend fun getGames(page: Int, pageSize: Int): GamesDto {
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

        return response.body<GamesDto>()
    }

    private companion object {
        const val GAMES_PATH = "games"
        const val PAGE = "page"
        const val PAGE_SIZE = "page_size"
        const val ORDERING = "ordering"
    }
}
