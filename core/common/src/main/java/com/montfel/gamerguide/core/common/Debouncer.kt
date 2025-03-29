package com.montfel.gamerguide.core.common

import kotlinx.coroutines.Job
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

object Debouncer {
    private const val DEBOUNCE_DEFAULT_TIME = 500L
    private var job: Job? = null

    fun <T> debounce(
        waitMs: Long = DEBOUNCE_DEFAULT_TIME,
        coroutineScope: CoroutineScope,
        text: T,
        destinationFunction: suspend (T) -> Unit,
    ) {
        job?.cancel()
        job = coroutineScope.launch {
            delay(waitMs)
            destinationFunction(text)
        }
    }
}
