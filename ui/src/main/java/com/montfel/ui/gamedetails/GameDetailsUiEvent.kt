package com.montfel.ui.gamedetails

internal sealed interface GameDetailsUiEvent {
    data class GetGameDetails(val id: Int) : GameDetailsUiEvent
}