package com.montfel.gamerguide.feature.lists.ui

sealed interface ListsUiEvent {
    data object GetAllFavoritedGames : ListsUiEvent
}
