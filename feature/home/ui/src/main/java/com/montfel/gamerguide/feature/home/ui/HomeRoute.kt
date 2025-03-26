package com.montfel.gamerguide.feature.home.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.paging.compose.collectAsLazyPagingItems
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeRoute(
    onNavigateToGameDetails: (id: Int) -> Unit,
    viewModel: HomeViewModel = koinViewModel()
) {
    val gamesLazyPagingItems = viewModel.gamesPagingDataFlow.collectAsLazyPagingItems()
    val searchQuery by viewModel.searchQuery.collectAsStateWithLifecycle()

    HomeScreen(
        searchQuery = searchQuery,
        gamesLazyPagingItems = gamesLazyPagingItems,
        onEvent = { event ->
            when (event) {
                is HomeUiEvent.NavigateToGameDetails -> onNavigateToGameDetails(event.id)
                is HomeUiEvent.SearchGames -> viewModel.updateSearchQuery(event.query)
            }
        }
    )
}
