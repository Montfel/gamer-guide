package com.montfel.gamerguide.presentation.navigation

import androidx.compose.runtime.Composable
import com.montfel.gamerguide.presentation.NavGraphs
import com.ramcosta.composedestinations.DestinationsNavHost

@Composable
fun NavigationComponent() {
    DestinationsNavHost(navGraph = NavGraphs.root)
}
