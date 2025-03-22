package com.montfel.gamerguide.core.network.interceptor

import com.montfel.gamerguide.core.common.buildconfig.BuildConfigFieldsProvider
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.HttpRequestPipeline
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import okhttp3.logging.HttpLoggingInterceptor

internal class HttpProviderImpl(
//    private val remoteConfigDataSource: RemoteConfigDataSource,
    private val buildConfigFieldsProvider: BuildConfigFieldsProvider,
) : HttpProvider {
    override suspend operator fun invoke(): HttpClient {
        val apiKey = "c95ba6ed614b46888777507b9e7e4eec" //remoteConfigDataSource.getString(RemoteConfig.API_KEY) fixme
        val buildConfigFields = buildConfigFieldsProvider()
        val isDebug = buildConfigFields.isDebug
        val logLevel =
            if (isDebug) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE

        return HttpClient(OkHttp) {
            expectSuccess = true

            engine {
                addNetworkInterceptor(
                    HttpLoggingInterceptor().apply {
                        level = logLevel
                    }
                )
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
        }
    }

    private companion object {
        const val API_KEY = "key"
    }
}
