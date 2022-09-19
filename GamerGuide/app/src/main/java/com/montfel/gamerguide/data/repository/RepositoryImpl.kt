package com.montfel.gamerguide.data.repository

import com.montfel.gamerguide.data.datasource.DataSource
import com.montfel.gamerguide.domain.model.GameDetails
import com.montfel.gamerguide.domain.repository.Repository
import com.montfel.gamerguide.helper.Response
import com.montfel.gamerguide.helper.requestWrapper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryImpl @Inject constructor(
    private val dataSource: DataSource,
) : Repository {
    override suspend fun getGameDetails(gameId: Int): Response<GameDetails> {
        return requestWrapper { dataSource.getGameDetails(gameId).toDomain() }
    }
}
