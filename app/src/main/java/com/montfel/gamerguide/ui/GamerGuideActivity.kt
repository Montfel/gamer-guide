package com.montfel.gamerguide.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.montfel.gamerguide.ui.navigation.NavigationComponent
import com.montfel.gamerguide.ui.theme.GamerGuideTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GamerGuideActivity : ComponentActivity() {

    private val viewModel: GamerGuideViewModel by viewModels() //fixme

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.initRemoteConfig() //fixme

        setContent {
            GamerGuideTheme {
                NavigationComponent()
            }
        }
    }
}