package com.montfel.gamerguide.core.common

import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException
import java.net.SocketException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import kotlin.coroutines.cancellation.CancellationException

suspend fun <T : Any> resultWrapper(call: suspend () -> T): ResultType<T> {
    return runCatching {
        ResultType.Success(call())
    }.getOrElse { exception ->
        exception.printStackTrace()

        ResultType.Failure(getErrorTypeFromThrowable(exception))
    }
}

fun getErrorTypeFromThrowable(it: Throwable) = when (it) {
    is RedirectResponseException -> { // for 3xx responses
        ErrorType.Http
    }

    is ClientRequestException -> { // for 4xx responses
        ErrorType.Http
    }

    is ServerResponseException -> { // for 5xx responses
        ErrorType.Http
    }

    is SocketException -> {
        ErrorType.Network
    }

    is UnknownHostException, is SocketTimeoutException -> {
        ErrorType.Offline
    }

    is CancellationException -> {
        throw it
    }

    else -> {
        it.printStackTrace()
        ErrorType.Unknown
    }
}
