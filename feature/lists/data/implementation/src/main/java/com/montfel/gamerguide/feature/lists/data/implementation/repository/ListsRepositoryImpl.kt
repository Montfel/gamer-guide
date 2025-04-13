package com.montfel.gamerguide.feature.lists.data.implementation.repository

import com.montfel.gamerguide.feature.lists.data.contract.model.FavoritedGameData
import com.montfel.gamerguide.feature.lists.data.contract.repository.ListsRepository
import com.montfel.gamerguide.feature.lists.data.implementation.datasource.local.ListsLocalDataSource
import kotlinx.coroutines.flow.Flow

class ListsRepositoryImpl (
    private val localDataSource: ListsLocalDataSource
): ListsRepository {
    override fun getAllFavoritedGames(): Flow<List<FavoritedGameData>> {
        return localDataSource.getAllFavoritedGames()
    }

    override fun isFavoritedGame(id: Int): Flow<Boolean> {
        return localDataSource.isFavoritedGame(id = id)
    }

    override suspend fun favoriteGame(favoritedGameData: FavoritedGameData) {
        localDataSource.favoriteGame(favoritedGameData)
    }

    override suspend fun unfavoriteGame(favoritedGameData: FavoritedGameData) {
        localDataSource.unfavoriteGame(favoritedGameData)
    }

    override suspend fun clearFavoritedGames() {
        localDataSource.clearFavoritedGames()
    }
}
