package com.montfel.gamerguide.feature.home.data.implementation.datasource.remote

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.montfel.gamerguide.feature.home.data.contract.model.GameData
import com.montfel.gamerguide.feature.home.data.implementation.datasource.remote.GamesPagingSource.Companion.ITEMS_PER_PAGE
import com.montfel.gamerguide.feature.home.data.implementation.service.HomeService
import kotlinx.coroutines.flow.Flow

class HomeRemoteDataSourceImpl(
    private val homeService: HomeService,
) : HomeRemoteDataSource {
    override fun getGames(): Flow<PagingData<GameData>> {
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            pagingSourceFactory = {
                GamesPagingSource(
                    service = homeService
                )
            }
        ).flow
    }
}
