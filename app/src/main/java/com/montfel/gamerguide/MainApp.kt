package com.montfel.gamerguide

import android.app.Application
import com.montfel.gamerguide.core.database.di.databaseModule
import com.montfel.gamerguide.core.network.di.networkModule
import com.montfel.gamerguide.core.remoteconfig.di.remoteConfigModule
import com.montfel.gamerguide.di.appModule
import com.montfel.gamerguide.feature.gamedetails.data.implementation.di.gameDetailsDataModule
import com.montfel.gamerguide.feature.gamedetails.domain.implementation.di.gameDetailsDomainModule
import com.montfel.gamerguide.feature.gamedetails.ui.di.gameDetailsUiModule
import com.montfel.gamerguide.feature.home.data.implementation.di.homeDataModule
import com.montfel.gamerguide.feature.home.domain.implementation.di.homeDomainModule
import com.montfel.gamerguide.feature.home.ui.di.homeUiModule
import com.montfel.gamerguide.feature.lists.data.implementation.di.listsDataModule
import com.montfel.gamerguide.feature.lists.domain.implementation.di.listsDomainModule
import com.montfel.gamerguide.feature.lists.ui.di.listsUiModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

internal class MainApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MainApp)

            modules(
                appModule,
                databaseModule,
                gameDetailsDomainModule,
                gameDetailsDataModule,
                gameDetailsUiModule,
                homeDataModule,
                homeDomainModule,
                homeUiModule,
                listsDataModule,
                listsDomainModule,
                listsUiModule,
                networkModule,
                remoteConfigModule,
            )
        }
    }
}
