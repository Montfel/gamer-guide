package com.montfel.gamerguide.core.designsystem

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.montfel.gamerguide.core.designsystem.resources.Res
import com.montfel.gamerguide.core.designsystem.resources.ic_close
import com.montfel.gamerguide.core.designsystem.resources.ic_search
import org.jetbrains.compose.resources.painterResource

@Composable
fun TextFieldCustom(query: String, onClear: () -> Unit, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = query,
        onValueChange = onValueChange,
        leadingIcon = {
            Icon(
                painter = painterResource(Res.drawable.ic_search),
                contentDescription = null
            )
        },
        trailingIcon = {
            IconButton(onClick = onClear) {
                Icon(
                    painter = painterResource(Res.drawable.ic_close),
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
