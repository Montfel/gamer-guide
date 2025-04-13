package com.montfel.gamerguide.feature.gamedetails.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.twotone.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.montfel.gamerguide.core.designsystem.theme.GamerGuideTheme

@Composable
internal fun GameDetailsScreen(
    uiState: GameDetailsUiState,
    onEvent: (GameDetailsUiEvent) -> Unit
) {
    uiState.gameDetails?.let { gameDetails ->
        Column(modifier = Modifier.safeDrawingPadding()) {
            AsyncImage(
                model = gameDetails.backgroundImage,
                contentDescription = null,
                modifier = Modifier.fillMaxWidth()
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                gameDetails.name?.let {
                    Text(
                        text = it,
                        modifier = Modifier.weight(1f)
                    )
                }


                if (uiState.isFavoritedGame) {
                    IconButton(
                        onClick = { onEvent(GameDetailsUiEvent.UnfavoriteGame(gameDetails)) }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = null
                        )
                    }
                } else {
                    IconButton(
                        onClick = { onEvent(GameDetailsUiEvent.FavoriteGame(gameDetails)) }
                    ) {
                        Icon(
                            imageVector = Icons.TwoTone.Star,
                            contentDescription = null
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun GameDetailsScreenPreview() {
    GamerGuideTheme {
        GameDetailsScreen(
            uiState = GameDetailsUiState(),
            onEvent = {}
        )
    }
}
