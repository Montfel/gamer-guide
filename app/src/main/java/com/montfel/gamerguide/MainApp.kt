package com.montfel.gamerguide

import android.app.Application
import com.montfel.gamerguide.core.network.di.networkKoinModule
import com.montfel.gamerguide.core.remoteconfig.di.remoteConfigKoinModule
import com.montfel.gamerguide.di.appModule
import com.montfel.gamerguide.feature.gamedetails.data.implementation.di.gameDetailsDataKoinModule
import com.montfel.gamerguide.feature.gamedetails.domain.implementation.di.gameDetailsDomainKoinModule
import com.montfel.gamerguide.feature.gamedetails.ui.di.gameDetailsUiKoinModule
import com.montfel.gamerguide.feature.home.data.implementation.di.homeDataKoinModule
import com.montfel.gamerguide.feature.home.domain.implementation.di.homeDomainKoinModule
import com.montfel.gamerguide.feature.home.ui.di.homeUiKoinModule
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
                gameDetailsDomainKoinModule,
                gameDetailsDataKoinModule,
                gameDetailsUiKoinModule,
                homeDataKoinModule,
                homeDomainKoinModule,
                homeUiKoinModule,
                networkKoinModule,
                remoteConfigKoinModule,
            )
        }
    }
}
