package com.montfel.ui.gamedetails

import com.montfel.domain.model.GameDetails
import com.montfel.ui.components.StateOfUi

internal data class GameDetailsUiState(
    val gameDetails: GameDetails? = null,
    val stateOfUi: StateOfUi = StateOfUi.Loading
)