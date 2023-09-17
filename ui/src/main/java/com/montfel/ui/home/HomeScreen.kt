package com.montfel.ui.home

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.montfel.ui.destinations.GameDetailsScreenDestination
import com.montfel.ui.theme.GamerGuideTheme
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@RootNavGraph(start = true)
@Destination
@Composable
internal fun HomeScreen(navigator: DestinationsNavigator) {
    HomeScreen(onEvent = { navigator.navigate(GameDetailsScreenDestination(id = 2)) })
}

@Composable
private fun HomeScreen(onEvent: () -> Unit) {
    Button(onClick = onEvent) {
        Text(text = "Go to game details")
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    GamerGuideTheme {
        HomeScreen(onEvent = {})
    }
}