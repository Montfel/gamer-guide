package com.montfel.gamerguide.core.designsystem.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.montfel.gamerguide.core.designsystem.theme.GenreContainerGrayColor

@Composable
fun GenreIcon (genreName: String, modifier: Modifier = Modifier) {
    Surface (modifier = modifier.padding(end = 8.dp), shape = CircleShape, color = GenreContainerGrayColor, contentColor = Color.White){
        Text(text = genreName, modifier.padding(horizontal = 8.dp, vertical = 3.dp))
    }
}

@Preview
@Composable
private fun GenreIconPreview() {
    GenreIcon("Testing")
}