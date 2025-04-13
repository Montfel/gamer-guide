package com.montfel.gamerguide.feature.home.data.implementation.datasource.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.montfel.gamerguide.feature.home.data.contract.model.GameData
import com.montfel.gamerguide.feature.home.data.implementation.mapper.toGameData
import com.montfel.gamerguide.feature.home.data.implementation.model.GameApi
import com.montfel.gamerguide.feature.home.data.implementation.service.HomeService

class GamesPagingSource(
    private val query: String,
    private val service: HomeService,
) : PagingSource<Int, GameData>() {
    override fun getRefreshKey(state: PagingState<Int, GameData>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.inc() ?: anchorPage?.nextKey?.dec()
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GameData> {
        return runCatching {
            val page = params.key ?: 1
            val response = service.getGames(
                query = query,
                page = page,
                pageSize = params.loadSize
            )
            val games = response.results.map(GameApi::toGameData)

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
