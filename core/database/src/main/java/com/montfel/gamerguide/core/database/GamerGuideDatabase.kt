package com.montfel.gamerguide.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.montfel.gamerguide.core.database.dao.FavoritedGamesDao
import com.montfel.gamerguide.core.database.model.entity.FavoritedGameEntity

@Database(
    entities = [FavoritedGameEntity::class],
    version = 1,
    exportSchema = false
)
abstract class GamerGuideDatabase: RoomDatabase() {
    abstract fun favoritedGamesDao(): FavoritedGamesDao
}
