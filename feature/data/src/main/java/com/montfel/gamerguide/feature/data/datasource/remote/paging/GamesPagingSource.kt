package com.montfel.gamerguide.feature.data.datasource.remote.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.montfel.gamerguide.feature.data.mapper.toGame
import com.montfel.gamerguide.feature.data.model.dto.GameDto
import com.montfel.gamerguide.feature.data.service.GamesService
import com.montfel.gamerguide.feature.domain.model.Game

class GamesPagingSource(
    private val service: GamesService,
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
            val games = response.results.map(GameDto::toGame)

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
