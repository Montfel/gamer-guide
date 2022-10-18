package com.montfel.di

import com.montfel.data.datasource.DataSource
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataSource = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://rawg.io/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DataSource::class.java)
    }
}
