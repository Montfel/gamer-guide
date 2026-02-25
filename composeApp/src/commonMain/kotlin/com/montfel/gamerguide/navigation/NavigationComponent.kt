package com.montfel.gamerguide.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.dropUnlessResumed
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import com.montfel.gamerguide.feature.gamedetails.ui.GameDetailsRoute
import com.montfel.gamerguide.feature.home.ui.HomeRoute
import gamerguide.composeapp.generated.resources.Res
import gamerguide.composeapp.generated.resources.compose_multiplatform
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import org.jetbrains.compose.resources.painterResource

private val configuration = SavedStateConfiguration {
    serializersModule = SerializersModule {
        polymorphic(NavKey::class) {
            subclass(Screen.Home::class, Screen.Home.serializer())
            subclass(Screen.GameDetails::class, Screen.GameDetails.serializer())
            subclass(Screen.Lists::class, Screen.Lists.serializer())
        }
    }
}

@Composable
fun NavigationComponent() {
    val backStack = rememberNavBackStack(configuration = configuration, Screen.Home)
    val navigationBarItems = listOf(
        NavigationItem(
            icon = painterResource(Res.drawable.compose_multiplatform),
            screen = Screen.Home
        ),
        NavigationItem(
            icon = painterResource(Res.drawable.compose_multiplatform),
            screen = Screen.Lists
        )
    )

    val currentScreen = backStack.last()

    Scaffold(
        bottomBar = {
            if (currentScreen in navigationBarItems.map(NavigationItem::screen)) {
                NavigationBarCustom(
                    currentScreen = currentScreen,
                    navigationBarItems = navigationBarItems,
                    onClick = { screen ->
                        if (screen == backStack.last()) return@NavigationBarCustom

                        if (screen in backStack) {
                            val droppedBackStack = backStack.dropLastWhile { it != screen }
                            backStack.clear()
                            backStack.addAll(droppedBackStack)
                        } else {
                            backStack.add(screen)
                        }
                    }
                )
            }
        }
    ) { paddingValues ->
        NavDisplay(
            backStack = backStack,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            entryDecorators = listOf(
                rememberSaveableStateHolderNavEntryDecorator(),
                rememberViewModelStoreNavEntryDecorator()
            ),
            onBack = backStack::removeLastOrNull,
            entryProvider = entryProvider {
                entry<Screen.Home> {
                    HomeRoute(onNavigateToGameDetails = { backStack.add(Screen.GameDetails(it)) })
                }
                entry<Screen.GameDetails> { key ->
                    GameDetailsRoute(id = key.id)
                }
                entry<Screen.Lists> {
                    Column(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Text("Lists")
                    }
                }
            },
        )
    }
}

@Composable
fun NavigationBarCustom(
    currentScreen: NavKey,
    navigationBarItems: List<NavigationItem>,
    onClick: (NavKey) -> Unit
) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface,
        contentColor = MaterialTheme.colorScheme.surface,
        tonalElevation = 0.dp,
        modifier = Modifier.height(80.dp)
    ) {
        navigationBarItems.forEach { navigationItem ->
            NavigationBarItem(
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    indicatorColor = MaterialTheme.colorScheme.surface,
                ),
                selected = navigationItem.screen == currentScreen,
                onClick = dropUnlessResumed { onClick(navigationItem.screen) },
                icon = {
                    Icon(
                        painter = navigationItem.icon,
                        contentDescription = null
                    )
                }
            )
        }
    }
}

data class NavigationItem(
    val icon: Painter,
    val screen: Screen
)

