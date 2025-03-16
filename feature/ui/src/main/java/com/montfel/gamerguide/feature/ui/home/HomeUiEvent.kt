package com.montfel.gamerguide.feature.ui.home

sealed interface HomeUiEvent {
    data class NavigateToGameDetails(val id: Int) : HomeUiEvent
}
