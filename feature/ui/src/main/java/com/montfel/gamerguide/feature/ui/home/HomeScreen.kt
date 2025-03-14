package com.montfel.gamerguide.feature.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.montfel.gamerguide.core.designsystem.theme.GamerGuideTheme

@Composable
internal fun HomeScreen(onEvent: () -> Unit) {
    Column(modifier = Modifier.safeDrawingPadding()) {
        Button(onClick = onEvent) {
            Text(text = "Go to game details")
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    GamerGuideTheme {
        HomeScreen(onEvent = {})
    }
}
