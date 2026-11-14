package com.montfel.gamerguide.feature.gamedetails.ui

import com.montfel.gamerguide.feature.gamedetails.domain.model.GameDetails

internal sealed interface GameDetailsUiEvent {
    data class UnfavoriteGame(val gameDetails: GameDetails) : GameDetailsUiEvent
    data class FavoriteGame(val gameDetails: GameDetails) : GameDetailsUiEvent
}
