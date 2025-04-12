package com.montfel.gamerguide.feature.gamedetails.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.montfel.gamerguide.core.common.StateOfUi
import com.montfel.gamerguide.feature.gamedetails.domain.contract.model.GameDetails
import com.montfel.gamerguide.feature.gamedetails.domain.contract.usecase.GetGameDetailsUseCase
import com.montfel.gamerguide.feature.gamedetails.ui.mapper.toFavoritedGame
import com.montfel.gamerguide.feature.lists.domain.contract.usecase.FavoriteGameUseCase
import com.montfel.gamerguide.feature.lists.domain.contract.usecase.IsFavoritedGameUseCase
import com.montfel.gamerguide.feature.lists.domain.contract.usecase.UnfavoriteGameUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class GameDetailsViewModel(
    private val getGameDetailsUseCase: GetGameDetailsUseCase,
    private val favoriteGameUseCase: FavoriteGameUseCase,
    private val unfavoriteGameUseCase: UnfavoriteGameUseCase,
    private val isFavoritedGameUseCase: IsFavoritedGameUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(GameDetailsUiState())
    val uiState = _uiState.asStateFlow()

    fun onEvent(event: GameDetailsUiEvent) {
        when (event) {
            is GameDetailsUiEvent.GetGameDetails -> getGameDetails(event.id)
            is GameDetailsUiEvent.FavoriteGame -> favoriteGame(event.gameDetails)
            is GameDetailsUiEvent.UnfavoriteGame -> unfavoriteGame(event.gameDetails)
            is GameDetailsUiEvent.IsFavoritedGame -> isFavoritedGame(event.id)
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

    private fun isFavoritedGame(id: Int) {
        viewModelScope.launch {
            isFavoritedGameUseCase(id = id).collect { isFavorited ->
                _uiState.update {
                    it.copy(isFavoritedGame = isFavorited)
                }
            }
        }
    }

    private fun favoriteGame(gameDetails: GameDetails) {
        viewModelScope.launch {
            favoriteGameUseCase(gameDetails.toFavoritedGame())
        }
    }

    private fun unfavoriteGame(gameDetails: GameDetails) {
        viewModelScope.launch {
            unfavoriteGameUseCase(gameDetails.toFavoritedGame())
        }
    }
}
