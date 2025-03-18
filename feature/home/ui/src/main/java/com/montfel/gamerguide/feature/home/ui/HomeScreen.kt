package com.montfel.gamerguide.feature.home.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemKey
import coil.compose.AsyncImage
import com.montfel.gamerguide.core.designsystem.theme.GamerGuideTheme
import com.montfel.gamerguide.feature.domain.model.Game
import kotlinx.coroutines.flow.flowOf
import com.montfel.gamerguide.core.designsystem.R

@Composable
fun HomeScreen(
    gamesLazyPagingItems: LazyPagingItems<Game>,
    onEvent: (HomeUiEvent) -> Unit
) {
    LazyColumn {
        items(
            count = gamesLazyPagingItems.itemCount,
            key = gamesLazyPagingItems.itemKey(Game::id)
        ) { index ->
            val gameItem = gamesLazyPagingItems[index]
            gameItem?.let { game ->
                Column(
                    modifier = Modifier
                        .safeDrawingPadding()
                        .clickable { onEvent(HomeUiEvent.NavigateToGameDetails(game.id)) },
                ) {
                    AsyncImage(
                        model = game.backgroundImage,
                        error = painterResource(R.drawable.baseline_videogame_asset_24),
                        contentDescription = null,
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier.fillMaxWidth()
                    )

                    game.name?.let {
                        Text(text = it)
                    }
                }
            }
        }

        item {
            when (gamesLazyPagingItems.loadState.refresh) {
                is LoadState.Error -> {
                    Text("Error refresh")
                }

                is LoadState.Loading -> {
                    CircularProgressIndicator()
                }

                is LoadState.NotLoading -> {}
            }
        }

        item {
            when (gamesLazyPagingItems.loadState.append) {
                is LoadState.Error -> {
                    Text("Error append")
                }

                is LoadState.Loading -> {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                    ) {
                        CircularProgressIndicator()
                    }
                }

                is LoadState.NotLoading -> {}
            }
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    GamerGuideTheme {
        HomeScreen(
            gamesLazyPagingItems = flowOf(
                PagingData.from(
                    listOf(
                        Game(
                            id = 9286,
                            name = "Boyd Branch",
                            backgroundImage = "praesent"
                        )
                    )
                )
            ).collectAsLazyPagingItems(),
            onEvent = {}
        )
    }
}
