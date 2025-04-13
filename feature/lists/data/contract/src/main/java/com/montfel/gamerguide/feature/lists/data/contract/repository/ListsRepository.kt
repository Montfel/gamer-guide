package com.montfel.gamerguide.feature.lists.data.contract.repository

import com.montfel.gamerguide.feature.lists.data.contract.model.FavoritedGameData
import kotlinx.coroutines.flow.Flow

interface ListsRepository {
    fun getAllFavoritedGames(): Flow<List<FavoritedGameData>>
    fun isFavoritedGame(id: Int): Flow<Boolean>
    suspend fun favoriteGame(favoritedGameData: FavoritedGameData)
    suspend fun unfavoriteGame(favoritedGameData: FavoritedGameData)
    suspend fun clearFavoritedGames()
}
