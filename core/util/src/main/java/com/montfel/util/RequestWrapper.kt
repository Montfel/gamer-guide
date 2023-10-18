package com.montfel.util

import java.net.SocketException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import kotlin.coroutines.cancellation.CancellationException
import retrofit2.HttpException

suspend fun <T : Any> requestWrapper(call: suspend () -> T): Result<T> {

    return try {
        Result.Success(call())
    } catch (exception: Exception) {
        exception.printStackTrace()

        when (exception) {
            is HttpException -> {
                Result.Failure(
                    Error.HttpError(
                        message = "message: ${exception.message()} \n " +
                            "code: ${exception.code()} \n " +
                            "body: ${exception.response()?.errorBody()?.string()}"
                    )
                )
            }

            is SocketException -> {
                Result.Failure(Error.NetworkError(exception.message.orEmpty()))
            }

            is UnknownHostException, is SocketTimeoutException -> {
                Result.Failure(Error.OfflineError(exception.message.orEmpty()))
            }

            is CancellationException -> {
                Result.Failure(Error.RequestCancelled(exception.message.orEmpty()))
            }

            else -> {
                Result.Failure(Error.UnknownError(exception.message.orEmpty()))
            }
        }
    }
}
