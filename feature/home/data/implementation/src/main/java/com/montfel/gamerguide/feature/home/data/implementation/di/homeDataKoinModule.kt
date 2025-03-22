package com.montfel.gamerguide.feature.home.data.implementation.di

import com.montfel.gamerguide.feature.domain.repository.HomeRepository
import com.montfel.gamerguide.feature.home.data.implementation.repository.HomeRepositoryImpl
import com.montfel.gamerguide.feature.home.data.implementation.service.HomeService
import com.montfel.gamerguide.feature.home.data.implementation.service.HomeServiceImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val homeDataKoinModule = module {
    singleOf(::HomeRepositoryImpl) { bind<HomeRepository>() }
    singleOf(::HomeServiceImpl) { bind<HomeService>() }
}
