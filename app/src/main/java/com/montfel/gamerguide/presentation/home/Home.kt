package com.montfel.gamerguide.presentation.home

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.montfel.gamerguide.presentation.navigation.Screen
import org.koin.androidx.compose.getViewModel

@Composable
fun Home(
    navController: NavController,
    viewModel: HomeViewModel = getViewModel()
) {
//    val uiState by viewModel.uiState.collectAsState()
    Button(onClick = { navController.navigate(Screen.GameDetails.createRoute(2)) }) {
        Text(text = "Go to game detail")
    }
}
