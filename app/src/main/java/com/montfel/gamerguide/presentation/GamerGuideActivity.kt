package com.montfel.gamerguide.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import com.montfel.gamerguide.presentation.navigation.NavigationComponent
import com.montfel.gamerguide.presentation.theme.GamerGuideTheme

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

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GamerGuideTheme {
    }
}
