package com.montfel.gamerguide.core.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.montfel.gamerguide.core.navigation.component.NavigationBarCustom
import com.montfel.gamerguide.core.navigation.component.NavigationItem
import com.montfel.gamerguide.feature.gamedetails.ui.GameDetailsRoute
import com.montfel.gamerguide.feature.home.ui.HomeRoute
import com.montfel.gamerguide.feature.lists.ui.ListsScreen

@Composable
fun NavigationComponent() {
    val navigationBarItems =
        listOf(
            NavigationItem(
                icon = Icons.Default.Home,
                screen = Screen.Home
            ),
            NavigationItem(
                icon = Icons.AutoMirrored.Filled.List,
                screen = Screen.Lists
            ),
        )

    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route.orEmpty()

    Scaffold(
        bottomBar = {
            if (currentRoute in navigationBarItems.map { it.screen::class.qualifiedName }) {
                NavigationBarCustom(
                    currentRoute = currentRoute,
                    navigationBarItems = navigationBarItems,
                    onClick = {
                        navController.navigate(it.screen) {
                            navController.graph.startDestinationRoute?.let { route ->
                                popUpTo(route) {
                                    saveState = true
                                }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home,
            modifier = Modifier.padding(paddingValues),
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

            composable<Screen.Lists> {
                ListsScreen()
            }
        }
    }
}
