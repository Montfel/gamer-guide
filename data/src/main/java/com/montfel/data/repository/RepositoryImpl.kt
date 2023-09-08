package com.montfel.data.repository

import com.montfel.data.dataSource.remote.network.GameRemoteDataSource
import com.montfel.data.dataSource.remote.remoteConfig.RemoteConfigDataSource
import com.montfel.domain.model.GameDetails
import com.montfel.domain.repository.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val gameRemoteDataSource: GameRemoteDataSource,
    private val remoteConfigDataSource: RemoteConfigDataSource
) : Repository {
    override suspend fun getGameDetails(gameId: Int): Result<GameDetails> {
        val apiKey = remoteConfigDataSource.getString(RemoteConfigDataSource.API_KEY)
        return gameRemoteDataSource.getGameDetails(gameId = gameId, apiKey = apiKey)
    }
}
