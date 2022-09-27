package com.montfel.data.repository

import com.montfel.common.Response
import com.montfel.common.requestWrapper
import com.montfel.data.datasource.DataSource
import com.montfel.domain.model.GameDetails
import com.montfel.domain.repository.Repository
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
