package com.montfel.gamerguide.feature.home.data.contract.repository

import androidx.paging.PagingData
import com.montfel.gamerguide.feature.home.data.contract.model.GameData
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    fun getGames(query: String): Flow<PagingData<GameData>>
}
