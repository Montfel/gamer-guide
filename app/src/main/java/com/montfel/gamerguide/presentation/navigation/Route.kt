package com.montfel.gamerguide.presentation.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")

    object GameDetails : Screen("gamedetails/{id}") {
        fun createRoute(id: Int) = "gamedetails/$id"
    }
}
