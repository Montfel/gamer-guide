package com.montfel.gamerguide.feature.gamedetails.appdemo

import android.app.Application
import com.montfel.gamerguide.feature.data.di.dataModule
import com.montfel.gamerguide.feature.gamedetails.appdemo.di.appModule
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

            modules(appModule, dataModule, gameDetailsUiKoinModule)
        }
    }
}
