package com.montfel.data.repository

import com.montfel.data.datasource.DataSource
import com.montfel.domain.model.GameDetails
import com.montfel.domain.repository.Repository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryImpl @Inject constructor(
    private val dataSource: DataSource,
) : Repository {
    override suspend fun getGameDetails(gameId: Int): Result<GameDetails> {
        return runCatching { dataSource.getGameDetails(gameId).toDomain() }
    }
}
