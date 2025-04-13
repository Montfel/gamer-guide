package com.montfel.gamerguide.feature.lists.ui

import com.montfel.gamerguide.core.common.StateOfUi
import com.montfel.gamerguide.feature.lists.domain.contract.model.FavoritedGame

data class ListsUiState(
    val favoritedGames: List<FavoritedGame> = emptyList(),
    val stateOfUi: StateOfUi = StateOfUi.Loading,
)
