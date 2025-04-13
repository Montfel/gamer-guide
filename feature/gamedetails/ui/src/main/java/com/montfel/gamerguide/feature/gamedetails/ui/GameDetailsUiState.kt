package com.montfel.gamerguide.feature.gamedetails.ui

import com.montfel.gamerguide.feature.gamedetails.domain.contract.model.GameDetails
import com.montfel.gamerguide.core.common.StateOfUi

data class GameDetailsUiState(
    val gameDetails: GameDetails? = null,
    val isFavoritedGame: Boolean = false,
    val stateOfUi: StateOfUi = StateOfUi.Loading,
)
