package com.montfel.gamerguide.feature.lists.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.montfel.gamerguide.core.designsystem.theme.GamerGuideTheme

@Composable
fun ListsScreen(
) {
    Text("Lists")
}

@Preview
@Composable
private fun ListsScreenPreview() {
    GamerGuideTheme {
        ListsScreen()
    }
}
