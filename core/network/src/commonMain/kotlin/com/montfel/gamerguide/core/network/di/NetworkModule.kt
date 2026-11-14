package com.montfel.gamerguide.core.network.di

import com.montfel.gamerguide.core.network.http.HttpProvider
import com.montfel.gamerguide.core.network.http.HttpProviderImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val networkModule = module {
    singleOf(::HttpProviderImpl) bind HttpProvider::class
}
