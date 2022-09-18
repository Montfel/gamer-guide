package com.montfel.gamerguide.presentation.home

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.montfel.gamerguide.presentation.navigation.Screen

@Composable
fun Home(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
//    val uiState by viewModel.uiState.collectAsState()
    Button(onClick = { navController.navigate(Screen.GameDetail.createRoute(1)) }) {
        Text(text = "Go to game detail")
    }
}
