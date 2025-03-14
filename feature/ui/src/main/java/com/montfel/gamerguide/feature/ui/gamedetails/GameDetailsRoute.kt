package com.montfel.gamerguide.feature.ui.gamedetails

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.montfel.gamerguide.core.common.StateOfUi
import com.montfel.gamerguide.core.designsystem.components.ErrorScreen
import com.montfel.gamerguide.core.designsystem.components.LoadingScreen

@Composable
fun GameDetailsRoute(
    id: Int,
    viewModel: GameDetailsViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = Unit) {
        viewModel.onEvent(GameDetailsUiEvent.GetGameDetails(id))
    }

    when (val stateOfUi = uiState.stateOfUi) {
        is StateOfUi.Error -> {
            ErrorScreen(
                error = stateOfUi.errorType,
                onClick = { viewModel.onEvent(GameDetailsUiEvent.GetGameDetails(id)) }
            )
        }

        is StateOfUi.Loading -> {
            LoadingScreen()
        }

        is StateOfUi.Success -> {
            GameDetailsScreen(uiState = uiState)
        }
    }
}
