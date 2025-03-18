package com.montfel.gamerguide.feature.home.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.montfel.gamerguide.feature.domain.model.Game
import com.montfel.gamerguide.feature.domain.repository.GameDetailsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.emptyFlow

class HomeViewModel(
    private val gameDetailsRepository: GameDetailsRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()

    var gamesPagingDataFlow: Flow<PagingData<Game>> = emptyFlow()

    init {
        getGames()
    }

    private fun getGames() {
        gamesPagingDataFlow = gameDetailsRepository.getGames().cachedIn(viewModelScope)
    }
}
