package com.montfel.ui.gamedetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.montfel.domain.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
internal class GameDetailsViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _uiState = MutableStateFlow(GameDetailsUiState())
    val uiState: StateFlow<GameDetailsUiState> = _uiState

    fun onEvent(event: GameDetailsEvent) {
        when (event) {
            is GameDetailsEvent.GetGameDetails -> getGameDetails(event.id)
        }
    }

    private fun getGameDetails(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val gameDetails = repository.getGameDetails(gameId = id)
            gameDetails.onSuccess { result ->
                _uiState.update {
                    it.copy(
                        gameDetails = result
                    )
                }
            }
        }
    }
}
