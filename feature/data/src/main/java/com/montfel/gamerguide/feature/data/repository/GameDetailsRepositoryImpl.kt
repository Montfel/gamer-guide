package com.montfel.gamerguide.feature.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.montfel.gamerguide.core.common.ResultType
import com.montfel.gamerguide.feature.data.datasource.remote.network.GameDetailsRemoteDataSource
import com.montfel.gamerguide.feature.data.datasource.remote.paging.GamesPagingSource
import com.montfel.gamerguide.feature.data.datasource.remote.paging.GamesPagingSource.Companion.ITEMS_PER_PAGE
import com.montfel.gamerguide.feature.data.service.GamesService
import com.montfel.gamerguide.feature.domain.model.GameDetails
import com.montfel.gamerguide.feature.domain.model.Game
import com.montfel.gamerguide.feature.domain.repository.GameDetailsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class GameDetailsRepositoryImpl(
    private val gameDetailsRemoteDataSource: GameDetailsRemoteDataSource,
    private val gamesService: GamesService
) : GameDetailsRepository {
    override suspend fun getGameDetails(gameId: Int): ResultType<GameDetails> {
        return withContext(Dispatchers.IO) {
            gameDetailsRemoteDataSource.getGameDetails(gameId = gameId)
        }
    }

    override fun getGames(): Flow<PagingData<Game>> {
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            pagingSourceFactory = {
                GamesPagingSource(
                    service = gamesService
                )
            }
        ).flow
    }
}
