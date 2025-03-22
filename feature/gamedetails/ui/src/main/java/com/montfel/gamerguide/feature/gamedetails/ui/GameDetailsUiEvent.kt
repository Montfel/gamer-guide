package com.montfel.gamerguide.feature.gamedetails.ui

sealed interface GameDetailsUiEvent {
    data class GetGameDetails(val id: Int) : GameDetailsUiEvent
}
