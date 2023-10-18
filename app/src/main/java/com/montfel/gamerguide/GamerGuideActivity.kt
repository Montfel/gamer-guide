package com.montfel.gamerguide

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import com.montfel.designsystem.theme.GamerGuideTheme
import com.montfel.gamerguide.navigation.NavigationComponent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GamerGuideActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            viewModel<GamerGuideViewModel>()

            GamerGuideTheme {
                NavigationComponent()
            }
        }
    }
}
