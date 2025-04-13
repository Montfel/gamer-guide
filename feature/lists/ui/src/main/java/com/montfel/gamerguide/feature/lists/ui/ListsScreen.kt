package com.montfel.gamerguide.feature.lists.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import coil3.compose.AsyncImage
import com.montfel.gamerguide.core.designsystem.R
import com.montfel.gamerguide.core.designsystem.theme.GamerGuideTheme

@Composable
fun ListsScreen(
    uiState: ListsUiState
) {
    LazyColumn {
        items(uiState.favoritedGames) {
            Column(
                modifier = Modifier
                    .safeDrawingPadding()
                    .clickable {  },
            ) {
                AsyncImage(
                    model = it.backgroundImage,
                    error = painterResource(R.drawable.baseline_videogame_asset_24),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier.fillMaxWidth()
                )

                it.name?.let {
                    Text(text = it)
                }
            }
        }
    }
}

@Preview
@Composable
private fun ListsScreenPreview() {
    GamerGuideTheme {
        ListsScreen(uiState = ListsUiState())
    }
}
