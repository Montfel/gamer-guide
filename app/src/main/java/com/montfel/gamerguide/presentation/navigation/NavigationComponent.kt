package com.montfel.gamerguide.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.montfel.gamerguide.presentation.gamedetail.GameDetail
import com.montfel.gamerguide.presentation.home.Home

@Composable
fun NavigationComponent() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
//        composable(Screen.Splash.route) {
//            Splash(navController = navController)
//        }
        composable(Screen.Home.route) {
            Home(navController = navController)
        }
        composable(
            route = Screen.GameDetails.route,
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                }
            )
        ) {
            GameDetail(
                id = it.arguments?.getInt("id") ?: 0,
                navController = navController
            )
        }
    }
}
