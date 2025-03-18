package com.montfel.gamerguide.feature.gamedetails.appdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.montfel.gamerguide.feature.gamedetails.ui.GameDetailsRoute

class GameDetailsAppDemoActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GameDetailsRoute(id = 2)
        }
    }
}
