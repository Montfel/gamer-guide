package com.montfel.gamerguide

import android.app.Application
import com.montfel.gamerguide.di.appModule
import com.montfel.gamerguide.feature.data.di.dataModule
import com.montfel.gamerguide.feature.gamedetails.ui.di.gameDetailsUiKoinModule
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

            modules(appModule, dataModule, gameDetailsUiKoinModule, homeUiKoinModule)
        }
    }
}
