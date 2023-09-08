package com.montfel.gamerguide.ui.navigation

import androidx.compose.runtime.Composable
import com.montfel.gamerguide.ui.NavGraphs
import com.ramcosta.composedestinations.DestinationsNavHost

@Composable
fun NavigationComponent() {
    DestinationsNavHost(navGraph = NavGraphs.root)
}
