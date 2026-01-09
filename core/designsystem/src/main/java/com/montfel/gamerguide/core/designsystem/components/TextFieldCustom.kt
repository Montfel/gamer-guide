package com.montfel.gamerguide.core.designsystem.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.montfel.gamerguide.core.designsystem.resources.drawableDesignSystem

@Composable
fun TextFieldCustom(query: String, onClear: () -> Unit, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = query,
        onValueChange = onValueChange,
        leadingIcon = {
            Icon(
                painter = painterResource(drawableDesignSystem.ic_search),
                contentDescription = null
            )
        },
        trailingIcon = {
            IconButton(onClick = onClear) {
                Icon(
                    painter = painterResource(drawableDesignSystem.ic_close),
                    contentDescription = null
                )
            }
        },
        modifier = Modifier.fillMaxWidth()
    )
}

@Preview
@Composable
private fun TextFieldCustomPreview() {
    TextFieldCustom(
        query = "",
        onClear = {},
        onValueChange = {}
    )
}
