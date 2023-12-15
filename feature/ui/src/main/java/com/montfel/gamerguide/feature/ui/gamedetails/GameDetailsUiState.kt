package com.montfel.gamerguide.feature.ui.gamedetails

import com.montfel.gamerguide.feature.domain.model.GameDetails
import com.montfel.gamerguide.core.common.StateOfUi

internal data class GameDetailsUiState(
    val gameDetails: GameDetails? = null,
    val stateOfUi: StateOfUi = StateOfUi.Loading,
)