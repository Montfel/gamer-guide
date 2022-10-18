package com.montfel.core.di

import com.montfel.data.repository.RepositoryImpl
import com.montfel.di.dataSource
import com.montfel.domain.repository.Repository
import org.koin.dsl.module

val repositories = module {
    single<Repository> {
        RepositoryImpl(get())
    }
    includes(dataSource)
}
