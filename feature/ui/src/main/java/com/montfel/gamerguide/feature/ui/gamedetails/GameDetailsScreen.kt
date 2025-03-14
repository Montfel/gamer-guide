package com.montfel.gamerguide.feature.ui.gamedetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.montfel.gamerguide.core.designsystem.theme.GamerGuideTheme

@Composable
internal fun GameDetailsScreen(
    uiState: GameDetailsUiState
) {
    uiState.gameDetails?.let {
        Column(modifier = Modifier.safeDrawingPadding()) {
            AsyncImage(
                model = it.backgroundImage,
                contentDescription = null,
                modifier = Modifier.fillMaxWidth()
            )

            Text(text = it.name)
        }
    }
}

@Preview
@Composable
private fun GameDetailsScreenPreview() {
    GamerGuideTheme {
        GameDetailsScreen(uiState = GameDetailsUiState())
    }
}
