package com.montfel.ui.gamedetails

internal sealed interface GameDetailsEvent {
    data class GetGameDetails(val id: Int) : GameDetailsEvent
}