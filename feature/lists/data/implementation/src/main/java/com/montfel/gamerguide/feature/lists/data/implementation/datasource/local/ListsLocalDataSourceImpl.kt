package com.montfel.gamerguide.feature.lists.data.implementation.datasource.local

import com.montfel.gamerguide.core.database.dao.FavoritedGamesDao
import com.montfel.gamerguide.core.database.model.entity.FavoritedGameEntity
import com.montfel.gamerguide.feature.lists.data.contract.model.FavoritedGameData
import com.montfel.gamerguide.feature.lists.data.implementation.mapper.toFavoritedGameData
import com.montfel.gamerguide.feature.lists.data.implementation.mapper.toFavoritedGameEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ListsLocalDataSourceImpl(
    private val favoritedGamesDao: FavoritedGamesDao
) : ListsLocalDataSource {
    override fun getAllFavoritedGames(): Flow<List<FavoritedGameData>> {
        return favoritedGamesDao.getAllFavoritedGames()
            .map { it.map(FavoritedGameEntity::toFavoritedGameData) }
    }

    override fun isFavoritedGame(id: Int): Flow<Boolean> {
        return favoritedGamesDao.isFavoritedGame(id = id)
    }

    override suspend fun favoriteGame(favoritedGameData: FavoritedGameData) {
        favoritedGamesDao.favoriteGame(favoritedGameData.toFavoritedGameEntity())
    }

    override suspend fun unfavoriteGame(favoritedGameData: FavoritedGameData) {
        favoritedGamesDao.unfavoriteGame(favoritedGameData.toFavoritedGameEntity())
    }

    override suspend fun clearFavoritedGames() {
        favoritedGamesDao.clearFavoritedGames()
    }
}
