package com.montfel.gamerguide.feature.ui.gamedetails

sealed interface GameDetailsUiEvent {
    data class GetGameDetails(val id: Int) : GameDetailsUiEvent
}
