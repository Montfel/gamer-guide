package com.montfel.gamerguide.feature.gamedetails.ui

import com.montfel.gamerguide.feature.gamedetails.domain.model.GameDetails

internal data class GameDetailsUiState(
    val gameDetails: GameDetails? = null,
    val isFavoritedGame: Boolean = false,
    val stateOfUi: StateOfUi = StateOfUi.Loading,
)

internal sealed interface StateOfUi {
    data object Loading : StateOfUi
    data object Error : StateOfUi
    data object Success : StateOfUi
}
