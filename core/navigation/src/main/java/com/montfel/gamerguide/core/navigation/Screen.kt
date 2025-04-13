package com.montfel.gamerguide.core.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed interface Screen {

    @Serializable
    data object Home : Screen

    @Serializable
    data class GameDetails(
        val id: Int
    ) : Screen

    @Serializable
    data object Lists : Screen
}
