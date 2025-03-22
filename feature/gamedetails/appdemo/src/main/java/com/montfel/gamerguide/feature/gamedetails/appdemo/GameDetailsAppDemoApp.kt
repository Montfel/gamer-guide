package com.montfel.gamerguide.feature.gamedetails.appdemo

import android.app.Application
import com.montfel.gamerguide.core.network.di.networkKoinModule
import com.montfel.gamerguide.feature.gamedetails.appdemo.di.gameDetailsAppDemoKoinModule
import com.montfel.gamerguide.feature.gamedetails.data.implementation.di.gameDetailsDataKoinModule
import com.montfel.gamerguide.feature.gamedetails.domain.implementation.di.gameDetailsDomainKoinModule
import com.montfel.gamerguide.feature.gamedetails.ui.di.gameDetailsUiKoinModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

internal class GameDetailsAppDemoApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@GameDetailsAppDemoApp)

            modules(
                gameDetailsAppDemoKoinModule,
                gameDetailsDataKoinModule,
                gameDetailsDomainKoinModule,
                gameDetailsUiKoinModule,
                networkKoinModule
            )
        }
    }
}
