package com.montfel.gamerguide.feature.home.data.implementation.datasource.remote

import androidx.paging.PagingData
import com.montfel.gamerguide.feature.home.data.contract.model.GameData
import kotlinx.coroutines.flow.Flow

interface HomeRemoteDataSource {
    fun getGames(): Flow<PagingData<GameData>>
}
