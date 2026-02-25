package com.montfel.gamerguide.di

import com.montfel.gamerguide.core.network.di.networkModule
import com.montfel.gamerguide.feature.gamedetails.data.di.gameDetailsDataModule
import com.montfel.gamerguide.feature.gamedetails.domain.di.gameDetailsDomainModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import com.montfel.gamerguide.feature.gamedetails.ui.di.gameDetailsUiModule
import com.montfel.gamerguide.feature.home.data.di.homeDataModule
import com.montfel.gamerguide.feature.home.domain.di.homeDomainModule
import com.montfel.gamerguide.feature.home.ui.di.homeUiModule

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)

        modules(
//            appModule,
//            databaseModule,
            gameDetailsDataModule,
            gameDetailsDomainModule,
            gameDetailsUiModule,
            homeDataModule,
            homeDomainModule,
            homeUiModule,
//            listsDataModule,
//            listsDomainModule,
//            listsUiModule,
            networkModule,
//            remoteConfigModule,
        )
    }
}
