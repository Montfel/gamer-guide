package com.montfel.gamerguide.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.montfel.gamerguide.feature.gamedetails.ui.GameDetailsRoute
import com.montfel.gamerguide.feature.home.ui.HomeRoute

@Composable
fun NavigationComponent() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home
    ) {
        composable<Screen.Home> {
            HomeRoute(
                onNavigateToGameDetails = { navController.navigate(Screen.GameDetails(it)) }
            )
        }

        composable<Screen.GameDetails> {
            val (id) = it.toRoute<Screen.GameDetails>()

            GameDetailsRoute(
                id = id,
            )
        }
    }
}
