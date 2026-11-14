package com.montfel.gamerguide.feature.home.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.montfel.gamerguide.feature.home.data.datasource.GamesPagingSource
import com.montfel.gamerguide.feature.home.data.service.HomeService
import com.montfel.gamerguide.feature.home.domain.model.Game
import com.montfel.gamerguide.feature.home.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow

internal class HomeRepositoryImpl(
    private val service: HomeService
) : HomeRepository {
    override fun getGames(query: String): Flow<PagingData<Game>> {
        return Pager(
            config = PagingConfig(pageSize = PAGE_SIZE),
            pagingSourceFactory = {
                GamesPagingSource(
                    query = query,
                    service = service
                )
            }
        ).flow
    }

    companion object {
        const val PAGE_SIZE = 20
    }
}
