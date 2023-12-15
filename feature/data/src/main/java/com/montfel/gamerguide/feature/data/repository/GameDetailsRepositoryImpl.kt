package com.montfel.gamerguide.feature.data.repository

import com.montfel.gamerguide.feature.data.datasource.remote.network.GameDetailsRemoteDataSource
import com.montfel.gamerguide.feature.data.datasource.remote.remoteConfig.RemoteConfig
import com.montfel.gamerguide.feature.data.datasource.remote.remoteConfig.RemoteConfigDataSource
import com.montfel.gamerguide.feature.domain.repository.GameDetailsRepository
import com.montfel.util.Result
import com.montfel.util.requestWrapper
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GameDetailsRepositoryImpl @Inject constructor(
    private val gameDetailsRemoteDataSource: GameDetailsRemoteDataSource,
    private val remoteConfigDataSource: RemoteConfigDataSource,
) : GameDetailsRepository {
    override suspend fun getGameDetails(gameId: Int): Result<com.montfel.gamerguide.feature.domain.model.GameDetails> {
        return withContext(Dispatchers.IO) {
            val apiKey = remoteConfigDataSource.getString(RemoteConfig.API_KEY) //fixme

            requestWrapper {
                gameDetailsRemoteDataSource.getGameDetails(
                    gameId = gameId,
                    apiKey = apiKey
                )
            }
        }
    }
}
