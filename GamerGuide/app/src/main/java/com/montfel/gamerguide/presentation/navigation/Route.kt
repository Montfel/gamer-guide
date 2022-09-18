package com.montfel.gamerguide.presentation.navigation

sealed class Screen(val route: String) {
//    object Splash: Screen("splash")

    object Home : Screen("home")

    object GameDetail : Screen("gamedetail/{id}") {
        fun createRoute(id: Int) = "gamedetail/$id"
    }
}
