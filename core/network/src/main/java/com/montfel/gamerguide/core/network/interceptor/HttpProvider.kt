package com.montfel.gamerguide.core.network.interceptor

import io.ktor.client.HttpClient

interface HttpProvider {
    suspend operator fun invoke(): HttpClient
}
