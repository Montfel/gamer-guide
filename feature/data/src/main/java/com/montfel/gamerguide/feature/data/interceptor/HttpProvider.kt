package com.montfel.gamerguide.feature.data.interceptor

import io.ktor.client.HttpClient

interface HttpProvider {
    suspend operator fun invoke(): HttpClient
}
