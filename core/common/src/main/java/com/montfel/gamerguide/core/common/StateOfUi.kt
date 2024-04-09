package com.montfel.gamerguide.core.common

sealed interface StateOfUi {
    data object Loading : StateOfUi
    data class Error(val errorType: ErrorType) : StateOfUi
    data object Success : StateOfUi
}
