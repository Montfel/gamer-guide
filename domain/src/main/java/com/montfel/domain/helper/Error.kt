package com.montfel.domain.helper

// fixme colocar textos no string resources
sealed class Error(
    val title: String,
    open val message: String,
) {
    data class OfflineError(
        override val message: String
    ) : Error(title = "Offline Error", message = message)

    data class HttpError(
        override val message: String,
    ) : Error(title = "Http Error", message = message)

    data class NetworkError(
        override val message: String
    ) : Error(title = "Network Error", message = message)

    data class UnknownError(
        override val message: String
    ) : Error(title = "Unknown Error", message = message)

    data class RequestCancelled(
        override val message: String
    ) : Error(title = "Request Cancelled", message = message)
}