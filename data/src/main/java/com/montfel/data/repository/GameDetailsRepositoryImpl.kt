package com.montfel.data.repository

import com.montfel.data.dataSource.remote.network.GameDetailsRemoteDataSource
import com.montfel.data.dataSource.remote.remoteConfig.RemoteConfigDataSource
import com.montfel.data.helper.requestWrapper
import com.montfel.domain.helper.Result
import com.montfel.domain.model.GameDetails
import com.montfel.domain.repository.GameDetailsRepository
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GameDetailsRepositoryImpl @Inject constructor(
    private val gameDetailsRemoteDataSource: GameDetailsRemoteDataSource,
    private val remoteConfigDataSource: RemoteConfigDataSource
) : GameDetailsRepository {
    override suspend fun getGameDetails(gameId: Int): Result<GameDetails> {
        return withContext(Dispatchers.IO) {
            val apiKey = remoteConfigDataSource.getString(RemoteConfigDataSource.API_KEY) //fixme

            requestWrapper {
                gameDetailsRemoteDataSource.getGameDetails(
                    gameId = gameId,
                    apiKey = apiKey
                )
            }
        }
    }
}
