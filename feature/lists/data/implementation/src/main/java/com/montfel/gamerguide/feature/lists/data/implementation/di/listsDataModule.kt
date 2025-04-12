package com.montfel.gamerguide.feature.lists.data.implementation.di

import com.montfel.gamerguide.feature.lists.data.contract.repository.ListsRepository
import com.montfel.gamerguide.feature.lists.data.implementation.datasource.local.ListsLocalDataSource
import com.montfel.gamerguide.feature.lists.data.implementation.datasource.local.ListsLocalDataSourceImpl
import com.montfel.gamerguide.feature.lists.data.implementation.repository.ListsRepositoryImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val listsDataModule = module {
    singleOf(::ListsLocalDataSourceImpl) bind ListsLocalDataSource::class
    singleOf(::ListsRepositoryImpl) bind ListsRepository::class
}
