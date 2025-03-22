package com.montfel.gamerguide.feature.domain.repository

import androidx.paging.PagingData
import com.montfel.gamerguide.feature.domain.model.Game
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    fun getGames(): Flow<PagingData<Game>>
}
