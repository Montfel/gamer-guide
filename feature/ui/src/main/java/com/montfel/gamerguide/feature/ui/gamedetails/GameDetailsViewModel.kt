package com.montfel.gamerguide.feature.ui.gamedetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.montfel.gamerguide.feature.domain.repository.GameDetailsRepository
import com.montfel.util.Result
import com.montfel.util.StateOfUi
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
internal class GameDetailsViewModel @Inject constructor(
    private val gameDetailsRepository: GameDetailsRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(GameDetailsUiState())
    val uiState: StateFlow<GameDetailsUiState> = _uiState

    fun onEvent(event: GameDetailsUiEvent) {
        when (event) {
            is GameDetailsUiEvent.GetGameDetails -> getGameDetails(event.id)
        }
    }

    private fun getGameDetails(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.update { it.copy(stateOfUi = StateOfUi.Loading) }

            when (val result = gameDetailsRepository.getGameDetails(gameId = id)) {
                is Result.Success -> {
                    _uiState.update {
                        it.copy(
                            gameDetails = result.data,
                            stateOfUi = StateOfUi.Success
                        )
                    }
                }

                is Result.Failure -> {
                    _uiState.update {
                        it.copy(
                            stateOfUi = StateOfUi.Error(
                                title = result.error.title,
                                message = result.error.message,
                            )
                        )
                    }
                }
            }
        }
    }
}
