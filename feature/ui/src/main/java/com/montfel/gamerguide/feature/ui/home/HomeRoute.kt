package com.montfel.gamerguide.feature.ui.home

import androidx.compose.runtime.Composable

@Composable
fun HomeRoute(
    onNavigateToGameDetails: (id: Int) -> Unit,
) {
    HomeScreen(onEvent = { onNavigateToGameDetails(2) })
}
