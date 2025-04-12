package com.montfel.gamerguide.core.database.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.montfel.gamerguide.core.database.util.Constants
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = Constants.FAVORITED_GAMES_TABLE)
data class FavoritedGameEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String?,
    val backgroundImage: String?
)
