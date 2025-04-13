package com.montfel.gamerguide.feature.home.data.implementation.datasource.remote

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.montfel.gamerguide.feature.home.data.contract.model.GameData
import com.montfel.gamerguide.feature.home.data.implementation.service.HomeService
import kotlinx.coroutines.flow.Flow

class HomeRemoteDataSourceImpl(
    private val homeService: HomeService,
) : HomeRemoteDataSource {
    override fun getGames(query: String): Flow<PagingData<GameData>> {
        return Pager(
            config = PagingConfig(pageSize = PAGE_SIZE),
            pagingSourceFactory = {
                GamesPagingSource(
                    query = query,
                    service = homeService
                )
            }
        ).flow
    }

    companion object {
        const val PAGE_SIZE = 20
    }
}
