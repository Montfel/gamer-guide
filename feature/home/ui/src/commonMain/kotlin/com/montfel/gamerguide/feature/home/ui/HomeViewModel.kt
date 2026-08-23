package com.montfel.gamerguide.feature.home.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.montfel.gamerguide.feature.home.domain.usecase.GetGamesUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.update

@OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
internal class HomeViewModel(
    private val getGamesUseCase: GetGamesUseCase,
) : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()

    var searchQuery = MutableStateFlow("")
        private set

    val gamesPagingDataFlow = searchQuery
        .debounce(SEARCH_DEBOUNCE_MILLIS)
        .flatMapLatest { query ->
            getGamesUseCase(query = query)
        }.cachedIn(viewModelScope)

    fun updateSearchQuery(query: String) {
        searchQuery.update { query }
    }

    private companion object {
        const val SEARCH_DEBOUNCE_MILLIS = 500L
    }
}
