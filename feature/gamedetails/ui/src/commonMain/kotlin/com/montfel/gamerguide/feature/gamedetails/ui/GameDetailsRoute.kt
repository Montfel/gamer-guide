package com.montfel.gamerguide.feature.gamedetails.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.montfel.gamerguide.core.designsystem.ErrorScreen
import com.montfel.gamerguide.core.designsystem.LoadingScreen
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun GameDetailsRoute(
    id: Int,
) {
    val viewModel: GameDetailsViewModel = koinViewModel { parametersOf(id) }
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    when (uiState.stateOfUi) {
        is StateOfUi.Error -> {
            ErrorScreen(onClick = viewModel::getGameDetails)
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
