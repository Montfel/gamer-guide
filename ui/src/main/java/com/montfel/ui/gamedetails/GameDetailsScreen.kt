package com.montfel.ui.gamedetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.montfel.ui.components.ErrorScreen
import com.montfel.ui.components.LoadingScreen
import com.montfel.ui.components.StateOfUi
import com.montfel.ui.theme.GamerGuideTheme
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
internal fun GameDetailsScreen(
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
                title = stateOfUi.title,
                message = stateOfUi.message,
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

@Composable
private fun GameDetailsScreen(
    uiState: GameDetailsUiState
) {
    uiState.gameDetails?.let {
        Column(modifier = Modifier.safeDrawingPadding()) {
            AsyncImage(
                model = it.backgroundImage,
                contentDescription = null,
                modifier = Modifier.fillMaxWidth()
            )

            Text(text = it.name)
        }
    }
}

@Preview
@Composable
private fun GameDetailsScreenPreview() {
    GamerGuideTheme {
        GameDetailsScreen(uiState = GameDetailsUiState())
    }
}
