package com.montfel.gamerguide.core.navigation.component

import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.montfel.gamerguide.core.navigation.Screen

@Composable
fun NavigationBarCustom(
    currentRoute: String,
    navigationBarItems: List<NavigationItem>,
    onClick: (NavigationItem) -> Unit
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
                selected = navigationItem.screen::class.qualifiedName == currentRoute,
                onClick = { onClick(navigationItem) },
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
