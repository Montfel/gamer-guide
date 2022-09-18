package com.montfel.gamerguide.presentation.home

import androidx.lifecycle.ViewModel
import com.montfel.gamerguide.domain.model.GameDetails
import com.montfel.gamerguide.domain.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

data class GameDetailUiState(
    val gameDetails: GameDetails? = null,
)

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _uiState = MutableStateFlow(GameDetailUiState())
    val uiState: StateFlow<GameDetailUiState> = _uiState
}
