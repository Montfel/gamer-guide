package com.montfel.gamerguide

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.AnticipateInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.montfel.gamerguide.navigation.NavigationComponent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                false // viewModel.isLoading
            }
            setOnExitAnimationListener { splashScreenView ->
                val slideUp = ObjectAnimator.ofFloat(
                    splashScreenView.view,
                    View.TRANSLATION_Y,
                    0f,
                    -splashScreenView.view.height.toFloat()
                )
                slideUp.interpolator = AnticipateInterpolator()
                slideUp.duration = ANIMATION_DURATION_IN_MILLISECONDS

                slideUp.doOnEnd { splashScreenView.remove() }

                slideUp.start()
            }
        }
        enableEdgeToEdge()

        setContent {
            NavigationComponent()
        }
    }

    private companion object {
        const val ANIMATION_DURATION_IN_MILLISECONDS = 200L
    }
}
