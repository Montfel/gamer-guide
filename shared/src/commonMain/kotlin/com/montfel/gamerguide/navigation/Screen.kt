package com.montfel.gamerguide.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface Screen: NavKey {

    @Serializable
    data object Home : Screen

    @Serializable
    data class GameDetails(
        val id: Int
    ) : Screen

    @Serializable
    data object Lists : Screen
}
