package com.montfel.ui.navigation

import androidx.compose.runtime.Composable
import com.montfel.ui.NavGraphs
import com.ramcosta.composedestinations.DestinationsNavHost

@Composable
fun NavigationComponent() {
    DestinationsNavHost(navGraph = NavGraphs.root)
}
