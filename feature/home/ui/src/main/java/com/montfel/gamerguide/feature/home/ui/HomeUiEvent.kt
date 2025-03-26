package com.montfel.gamerguide.feature.home.ui

sealed interface HomeUiEvent {
    data class NavigateToGameDetails(val id: Int) : HomeUiEvent
    data class SearchGames(val query: String) : HomeUiEvent
}
