package com.montfel.di

import com.montfel.data.datasource.DataSource
import org.koin.dsl.module
import retrofit2.Retrofit

val dataSources = module {
    single {
        get<Retrofit>().create(DataSource::class.java)
    }
}
