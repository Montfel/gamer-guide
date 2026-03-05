package com.montfel.gamerguide

import androidx.compose.ui.window.ComposeUIViewController
import com.montfel.gamerguide.di.initKoin
import com.montfel.gamerguide.navigation.NavigationComponent

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) {
    NavigationComponent()
}
