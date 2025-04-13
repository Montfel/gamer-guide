package com.montfel.gamerguide.core.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.montfel.gamerguide.core.database.model.entity.FavoritedGameEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoritedGamesDao {

    @Query("SELECT * FROM favorited_games_table")
    fun getAllFavoritedGames(): Flow<List<FavoritedGameEntity>>

    @Query("SELECT EXISTS(SELECT 1 FROM favorited_games_table WHERE id = :id)")
    fun isFavoritedGame(id: Int): Flow<Boolean>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun favoriteGame(favoritedGame: FavoritedGameEntity)

    @Delete
    suspend fun unfavoriteGame(favoritedGame: FavoritedGameEntity)

    @Query("DELETE FROM favorited_games_table")
    suspend fun clearFavoritedGames()
}
