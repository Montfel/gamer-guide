package com.montfel.gamerguide.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.montfel.gamerguide.ui.navigation.NavigationComponent
import com.montfel.gamerguide.ui.theme.GamerGuideTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GamerGuideActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            viewModel<GamerGuideViewModel>()

            GamerGuideTheme {
                NavigationComponent()
            }
        }
    }
}