package com.montfel.gamerguide.feature.gamedetails.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil3.compose.AsyncImage

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
//                        Icon(
//                            painter = painterResource(drawableDesignSystem.ic_star_filled),
//                            contentDescription = null
//                        )
                    }
                } else {
                    IconButton(
                        onClick = { onEvent(GameDetailsUiEvent.FavoriteGame(gameDetails)) }
                    ) {
//                        Icon(
//                            painter = painterResource(drawableDesignSystem.ic_star),
//                            contentDescription = null
//                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun GameDetailsScreenPreview() {
//    GamerGuideTheme {
//        GameDetailsScreen(
//            uiState = GameDetailsUiState(),
//            onEvent = {}
//        )
//    }
}
