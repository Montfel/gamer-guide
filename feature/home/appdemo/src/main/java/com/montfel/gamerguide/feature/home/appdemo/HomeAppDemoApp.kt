package com.montfel.gamerguide.feature.home.appdemo

import android.app.Application
import com.montfel.gamerguide.feature.data.di.dataModule
import com.montfel.gamerguide.feature.home.ui.di.homeUiKoinModule
import com.montfel.gamerguide.feature.home.appdemo.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

internal class HomeAppDemoApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@HomeAppDemoApp)

            modules(appModule, dataModule, homeUiKoinModule)
        }
    }
}
