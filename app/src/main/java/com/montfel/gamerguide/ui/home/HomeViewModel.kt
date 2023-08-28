package com.montfel.gamerguide.ui.home

import androidx.lifecycle.ViewModel
import com.montfel.domain.model.GameDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class GameDetailUiState(
    val gameDetails: GameDetails? = null,
)

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(GameDetailUiState())
    val uiState: StateFlow<GameDetailUiState> = _uiState
}
