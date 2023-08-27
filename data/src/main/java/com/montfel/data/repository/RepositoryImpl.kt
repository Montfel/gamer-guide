package com.montfel.data.repository

import com.montfel.data.datasource.GameService
import com.montfel.domain.model.GameDetails
import com.montfel.domain.repository.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val service: GameService
) : Repository {
    override suspend fun getGameDetails(gameId: Int): Result<GameDetails> {
        return runCatching { service.getGameDetails(gameId).toDomain() }
    }
}
