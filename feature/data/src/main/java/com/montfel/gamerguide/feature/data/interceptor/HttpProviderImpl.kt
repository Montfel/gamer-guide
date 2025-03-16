package com.montfel.gamerguide.feature.data.interceptor

import com.montfel.gamerguide.core.common.buildconfig.BuildConfigFieldsProvider
import com.montfel.gamerguide.feature.data.datasource.remote.remoteConfig.RemoteConfig
import com.montfel.gamerguide.feature.data.datasource.remote.remoteConfig.RemoteConfigDataSource
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.HttpRequestPipeline
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import okhttp3.logging.HttpLoggingInterceptor

internal class HttpProviderImpl(
    private val remoteConfigDataSource: RemoteConfigDataSource,
    private val buildConfigFieldsProvider: BuildConfigFieldsProvider,
) : HttpProvider {
    override suspend operator fun invoke(): HttpClient {
        val apiKey = remoteConfigDataSource.getString(RemoteConfig.API_KEY)
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
