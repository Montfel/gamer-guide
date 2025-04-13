package com.montfel.gamerguide.feature.lists.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.montfel.gamerguide.feature.lists.domain.contract.usecase.GetAllFavoritedGamesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ListsViewModel(
    private val getAllFavoritedGamesUseCase: GetAllFavoritedGamesUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(ListsUiState())
    val uiState = _uiState.asStateFlow()

    fun onEvent(event: ListsUiEvent) {
        when (event) {
            ListsUiEvent.GetAllFavoritedGames -> getAllFavoritedGames()
        }
    }

    private fun getAllFavoritedGames() {
        viewModelScope.launch {
            getAllFavoritedGamesUseCase()
                .distinctUntilChanged()
                .collect { favoritedGames ->
                    _uiState.update {
                        it.copy(favoritedGames = favoritedGames)
                    }
                }
        }
    }
}
