package com.montfel.gamerguide.feature.home.data.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.montfel.gamerguide.feature.home.data.mapper.toGame
import com.montfel.gamerguide.feature.home.data.model.GameData
import com.montfel.gamerguide.feature.home.data.service.HomeService
import com.montfel.gamerguide.feature.home.domain.model.Game

internal class GamesPagingSource(
    private val query: String,
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
                query = query,
                page = page,
                pageSize = params.loadSize
            )
            val games = response.results.map(GameData::toGame)

            LoadResult.Page(
                data = games,
                prevKey = if (page == 1) null else page.dec(),
                nextKey = if (games.isEmpty()) null else page.inc(),
            )
        }.getOrElse {
            LoadResult.Error(it)
        }
    }
}
