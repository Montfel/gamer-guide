package com.montfel.gamerguide.feature.gamedetails.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.montfel.gamerguide.core.common.StateOfUi
import com.montfel.gamerguide.core.designsystem.components.ErrorScreen
import com.montfel.gamerguide.core.designsystem.components.LoadingScreen
import org.koin.androidx.compose.koinViewModel

@Composable
fun GameDetailsRoute(
    id: Int,
    viewModel: GameDetailsViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = Unit) {
        viewModel.onEvent(GameDetailsUiEvent.GetGameDetails(id))
        viewModel.onEvent(GameDetailsUiEvent.IsFavoritedGame(id))
    }

    when (uiState.stateOfUi) {
        is StateOfUi.Error -> {
            ErrorScreen(
                onClick = { viewModel.onEvent(GameDetailsUiEvent.GetGameDetails(id)) }
            )
        }

        is StateOfUi.Loading -> {
            LoadingScreen()
        }

        is StateOfUi.Success -> {
            GameDetailsScreen(
                uiState = uiState,
                onEvent = viewModel::onEvent
            )
        }
    }
}
