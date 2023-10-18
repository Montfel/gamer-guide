package com.montfel.util

sealed interface StateOfUi {
    data object Loading : StateOfUi
    data class Error(
        val title: String,
        val message: String,
    ) : StateOfUi

    data object Success : StateOfUi
}