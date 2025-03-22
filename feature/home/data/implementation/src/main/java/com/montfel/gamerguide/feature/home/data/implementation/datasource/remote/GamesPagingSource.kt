package com.montfel.gamerguide.feature.home.data.implementation.datasource.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.montfel.gamerguide.feature.domain.model.Game
import com.montfel.gamerguide.feature.home.data.implementation.mapper.toGame
import com.montfel.gamerguide.feature.home.data.implementation.model.GameApi
import com.montfel.gamerguide.feature.home.data.implementation.service.HomeService

class GamesPagingSource(
    private val service: HomeService,
) : PagingSource<Int, Game>() {
    override fun getRefreshKey(state: PagingState<Int, Game>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.inc() ?: anchorPage?.nextKey?.dec()
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Game> {
        return runCatching {
            val page = params.key ?: 1
            val response = service.getGames(
                page = page,
                pageSize = ITEMS_PER_PAGE
            )
            val games = response.results.map(GameApi::toGame)

            LoadResult.Page(
                data = games,
                prevKey = if (page == 1) null else page.dec(),
                nextKey = if (games.isEmpty()) null else page.inc(),
            )
        }.getOrElse {
            LoadResult.Error(it)
        }
    }

    companion object {
        const val ITEMS_PER_PAGE = 20
    }
}
