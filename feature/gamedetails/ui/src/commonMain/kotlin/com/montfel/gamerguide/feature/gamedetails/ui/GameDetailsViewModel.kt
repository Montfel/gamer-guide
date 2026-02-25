package com.montfel.gamerguide.feature.gamedetails.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.montfel.gamerguide.feature.gamedetails.domain.model.GameDetails
import com.montfel.gamerguide.feature.gamedetails.domain.usecase.GetGameDetailsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class GameDetailsViewModel(
    private val id: Int,
    private val getGameDetailsUseCase: GetGameDetailsUseCase,
//    private val favoriteGameUseCase: FavoriteGameUseCase,
//    private val unfavoriteGameUseCase: UnfavoriteGameUseCase,
//    private val isFavoritedGameUseCase: IsFavoritedGameUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(GameDetailsUiState())
    val uiState = _uiState.asStateFlow()

    init {
        getGameDetails()
        isFavoritedGame()
    }

    fun onEvent(event: GameDetailsUiEvent) {
        when (event) {
            is GameDetailsUiEvent.FavoriteGame -> favoriteGame(event.gameDetails)
            is GameDetailsUiEvent.UnfavoriteGame -> unfavoriteGame(event.gameDetails)
        }
    }

    private fun getGameDetails() {
        viewModelScope.launch {
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
                    println("===> $it")
                    _uiState.update {
                        it.copy(stateOfUi = StateOfUi.Error)
                    }
                }
        }
    }

    private fun isFavoritedGame() {
        viewModelScope.launch {
//            isFavoritedGameUseCase(id = id)
//                .distinctUntilChanged()
//                .collect { isFavorited ->
//                _uiState.update {
//                    it.copy(isFavoritedGame = isFavorited)
//                }
//            }
        }
    }

    private fun favoriteGame(gameDetails: GameDetails) {
        viewModelScope.launch {
//            favoriteGameUseCase(gameDetails.toFavoritedGame())
        }
    }

    private fun unfavoriteGame(gameDetails: GameDetails) {
        viewModelScope.launch {
//            unfavoriteGameUseCase(gameDetails.toFavoritedGame())
        }
    }
}
