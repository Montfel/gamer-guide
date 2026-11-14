package com.montfel.gamerguide.core.network.http

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.HttpRequestPipeline
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

internal class HttpProviderImpl : HttpProvider {
    override suspend operator fun invoke(): HttpClient {
        val apiKey =
            "c95ba6ed614b46888777507b9e7e4eec" //remoteConfigDataSource.getString(RemoteConfig.API_KEY) fixme

        return HttpClient {
            expectSuccess = true

            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        println("KTOR_LOG: $message")
                    }
                }
                level = LogLevel.BODY
            }

            install(ContentNegotiation) {
                json(
                    Json {
                        explicitNulls = false
                        ignoreUnknownKeys = true
                    }
                )
            }

            install("ApiKey") {
                requestPipeline.intercept(HttpRequestPipeline.Before) {
                    val urlBuilder = context.url
                    urlBuilder.parameters.append(API_KEY, apiKey)
                }
            }

            defaultRequest {
                url(BASE_URL)
            }
        }
    }

    private companion object {
        const val BASE_URL = "https://rawg.io/api/"
        const val API_KEY = "key"
    }
}
