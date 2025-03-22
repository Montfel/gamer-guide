package com.montfel.gamerguide.feature.home.data.implementation.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.montfel.gamerguide.feature.domain.model.Game
import com.montfel.gamerguide.feature.domain.repository.HomeRepository
import com.montfel.gamerguide.feature.home.data.implementation.datasource.remote.GamesPagingSource
import com.montfel.gamerguide.feature.home.data.implementation.datasource.remote.GamesPagingSource.Companion.ITEMS_PER_PAGE
import com.montfel.gamerguide.feature.home.data.implementation.service.HomeService
import kotlinx.coroutines.flow.Flow

class HomeRepositoryImpl(
    private val homeService: HomeService //fixme
) : HomeRepository {
    override fun getGames(): Flow<PagingData<Game>> {
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
