package com.montfel.gamerguide.feature.gamedetails.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.montfel.gamerguide.core.common.StateOfUi
import com.montfel.gamerguide.feature.gamedetails.domain.contract.usecase.GetGameDetailsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class GameDetailsViewModel(
    private val getGameDetailsUseCase: GetGameDetailsUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(GameDetailsUiState())
    val uiState = _uiState.asStateFlow()

    fun onEvent(event: GameDetailsUiEvent) {
        when (event) {
            is GameDetailsUiEvent.GetGameDetails -> getGameDetails(event.id)
        }
    }

    private fun getGameDetails(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.update { it.copy(stateOfUi = StateOfUi.Loading) }

            getGameDetailsUseCase(gameId = id)
                .onSuccess { gameDetails ->
                    _uiState.update {
                        it.copy(
                            gameDetails = gameDetails,
                            stateOfUi = StateOfUi.Success
                        )
                    }
                }
                .onFailure {
                    _uiState.update {
                        it.copy(stateOfUi = StateOfUi.Error)
                    }
                }
        }
    }
}
