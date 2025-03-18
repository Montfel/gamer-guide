package com.montfel.gamerguide.feature.home.ui

import androidx.compose.runtime.Composable
import androidx.paging.compose.collectAsLazyPagingItems
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeRoute(
    onNavigateToGameDetails: (id: Int) -> Unit,
    viewModel: HomeViewModel = koinViewModel()
) {
    val gamesLazyPagingItems = viewModel.gamesPagingDataFlow.collectAsLazyPagingItems()

    HomeScreen(
        gamesLazyPagingItems = gamesLazyPagingItems,
        onEvent = { event ->
            when(event) {
                is HomeUiEvent.NavigateToGameDetails -> onNavigateToGameDetails(event.id)
            }
        }
    )
}
