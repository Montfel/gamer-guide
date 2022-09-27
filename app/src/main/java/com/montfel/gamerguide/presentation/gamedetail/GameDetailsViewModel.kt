package com.montfel.gamerguide.presentation.gamedetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.montfel.common.Response
import com.montfel.domain.model.GameDetails
import com.montfel.domain.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class GameDetailUiState(
    val gameDetails: GameDetails? = null
)

@HiltViewModel
class GameDetailViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _uiState = MutableStateFlow(GameDetailUiState())
    val uiState: StateFlow<GameDetailUiState> = _uiState

    fun getGameDetails(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val gameDetail = repository.getGameDetails(gameId = id)
            if (gameDetail is Response.Success) {
                _uiState.update {
                    it.copy(
                        gameDetails = gameDetail.data
                    )
                }
            }
        }
    }
}
