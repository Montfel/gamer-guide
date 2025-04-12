package com.montfel.gamerguide.feature.gamedetails.ui

import com.montfel.gamerguide.feature.gamedetails.domain.contract.model.GameDetails

sealed interface GameDetailsUiEvent {
    data class GetGameDetails(val id: Int) : GameDetailsUiEvent
    data class IsFavoritedGame(val id: Int) : GameDetailsUiEvent
    data class UnfavoriteGame(val gameDetails: GameDetails) : GameDetailsUiEvent
    data class FavoriteGame(val gameDetails: GameDetails) : GameDetailsUiEvent
}
