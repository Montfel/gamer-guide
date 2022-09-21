package com.montfel.gamerguide.presentation.gamedetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage

@Composable
fun GameDetail(
    id: Int,
    navController: NavController,
    viewModel: GameDetailViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(key1 = Unit) {
        viewModel.getGameDetails(id)
    }
    Column() {
        AsyncImage(
            model = uiState.gameDetails?.backgroundImage,
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
        )

        Text(text = uiState.gameDetails?.name ?: "")
    }
}
