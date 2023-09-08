package com.montfel.gamerguide.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import com.montfel.gamerguide.ui.navigation.NavigationComponent
import com.montfel.gamerguide.ui.theme.GamerGuideTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GamerGuideActivity : ComponentActivity() {

    private lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        firebaseAnalytics = Firebase.analytics
        setContent {
            GamerGuideTheme {
                NavigationComponent()
            }
        }
    }
}