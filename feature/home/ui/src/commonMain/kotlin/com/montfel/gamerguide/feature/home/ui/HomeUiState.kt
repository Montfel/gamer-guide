package com.montfel.gamerguide.feature.home.ui

internal data class HomeUiState(
    val stateOfUi: StateOfUi = StateOfUi.Loading,
)

internal sealed interface StateOfUi {
    data object Loading : StateOfUi
    data object Error : StateOfUi
    data object Success : StateOfUi
}
