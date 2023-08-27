package com.montfel.gamerguide.presentation.gamedetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun GameDetails(
    id: Int,
    viewModel: GameDetailsViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(key1 = Unit) {
        viewModel.getGameDetails(id)
    }
    Column {
        AsyncImage(
            model = uiState.gameDetails?.backgroundImage,
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
        )

        Text(text = uiState.gameDetails?.name ?: "")
    }
}
