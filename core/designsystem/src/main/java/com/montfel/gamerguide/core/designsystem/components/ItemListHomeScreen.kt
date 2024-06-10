package com.montfel.gamerguide.core.designsystem.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.montfel.gamerguide.core.designsystem.theme.CyanButtonColor
import com.montfel.gamerguide.core.designsystem.theme.GrayCardContainerColor

@Composable
fun ItemListHomeScreen(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .padding(horizontal = 15.dp, vertical = 8.dp)
            .height(125.dp)
            .width(330.dp),
        colors = CardDefaults.cardColors(containerColor = GrayCardContainerColor)
    ) {

        Row(
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 17.dp)
                .fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            AsyncImage(
                model = "https://media.rawg.io/media/games/b4e/b4e4c73d5aa4ec66bbf75375c4847a2b.jpg",
                contentDescription = "Item List Image",
                modifier = Modifier
                    .height(80.dp)
                    .width(80.dp)
            )

            Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.SpaceBetween) {
                Text(text = "Minecraft", maxLines = 1, overflow = TextOverflow.Ellipsis, color = Color.White)
                Text(text = "Release date: 03/06/2024",  overflow = TextOverflow.Ellipsis, color = Color.White)
                Row {
                    GenreIcon(genreName = "Action")
                    GenreIcon(genreName = "Shooter")
                }
            }

            OutlinedButton(
                onClick = { /*TODO*/ },
                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 1.dp),
                colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.Transparent),
                border = BorderStroke(1.dp, CyanButtonColor),
                shape = RoundedCornerShape(5.dp)
            ) {
                Text(text = "Details", color = CyanButtonColor)
            }

        }

    }

}

@Preview
@Composable
private fun ItemListHomeScreenPreview() {
    ItemListHomeScreen()
}