package com.montfel.gamerguide.feature.home.appdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.montfel.gamerguide.feature.home.ui.HomeRoute

class HomeAppDemoActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HomeRoute(
                onNavigateToGameDetails = {}
            )
        }
    }
}
