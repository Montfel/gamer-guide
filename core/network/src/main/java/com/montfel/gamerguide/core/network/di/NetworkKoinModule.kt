package com.montfel.gamerguide.core.network.di

import com.montfel.gamerguide.core.network.interceptor.HttpProvider
import com.montfel.gamerguide.core.network.interceptor.HttpProviderImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val networkKoinModule = module {
    singleOf(::HttpProviderImpl) { bind<HttpProvider>() }
}
