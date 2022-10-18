package com.montfel.gamerguide.presentation.home

import androidx.lifecycle.ViewModel
import com.montfel.domain.model.GameDetails
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class GameDetailUiState(
    val gameDetails: GameDetails? = null,
)

class HomeViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(GameDetailUiState())
    val uiState: StateFlow<GameDetailUiState> = _uiState
}
