package com.montfel.gamerguide.feature.domain.repository

import androidx.paging.PagingData
import com.montfel.gamerguide.core.common.ResultType
import com.montfel.gamerguide.feature.domain.model.GameDetails
import com.montfel.gamerguide.feature.domain.model.Game
import kotlinx.coroutines.flow.Flow

interface GameDetailsRepository {
    suspend fun getGameDetails(gameId: Int): ResultType<GameDetails>
    fun getGames(): Flow<PagingData<Game>>
}
