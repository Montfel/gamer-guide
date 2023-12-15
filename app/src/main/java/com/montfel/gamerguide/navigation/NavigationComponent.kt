package com.montfel.gamerguide.navigation

import androidx.compose.runtime.Composable
import com.montfel.gamerguide.feature.ui.NavGraphs
import com.ramcosta.composedestinations.DestinationsNavHost

@Composable
fun NavigationComponent() {
    DestinationsNavHost(navGraph = NavGraphs.root)
}
