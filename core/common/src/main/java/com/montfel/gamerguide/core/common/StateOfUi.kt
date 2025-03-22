package com.montfel.gamerguide.core.common

sealed interface StateOfUi {
    data object Loading : StateOfUi
    data object Error : StateOfUi
    data object Success : StateOfUi
}
