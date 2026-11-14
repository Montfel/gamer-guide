package com.montfel.gamerguide.feature.home.domain.repository

import androidx.paging.PagingData
import com.montfel.gamerguide.feature.home.domain.model.Game
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    fun getGames(query: String): Flow<PagingData<Game>>
}
