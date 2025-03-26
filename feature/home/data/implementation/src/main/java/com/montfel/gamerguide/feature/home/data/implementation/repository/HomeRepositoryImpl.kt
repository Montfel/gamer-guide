package com.montfel.gamerguide.feature.home.data.implementation.repository

import androidx.paging.PagingData
import com.montfel.gamerguide.feature.home.data.contract.model.GameData
import com.montfel.gamerguide.feature.home.data.contract.repository.HomeRepository
import com.montfel.gamerguide.feature.home.data.implementation.datasource.remote.HomeRemoteDataSource
import kotlinx.coroutines.flow.Flow

class HomeRepositoryImpl(
    private val remoteDataSource: HomeRemoteDataSource
) : HomeRepository {
    override fun getGames(query: String): Flow<PagingData<GameData>> {
        return remoteDataSource.getGames(query = query)
    }
}
