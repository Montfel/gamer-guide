package com.montfel.gamerguide.feature.home.appdemo

import android.app.Application
import com.montfel.gamerguide.core.network.di.networkKoinModule
import com.montfel.gamerguide.feature.home.appdemo.di.homeAppDemoKoinModule
import com.montfel.gamerguide.feature.home.data.implementation.di.homeDataKoinModule
import com.montfel.gamerguide.feature.home.domain.implementation.di.homeDomainKoinModule
import com.montfel.gamerguide.feature.home.ui.di.homeUiKoinModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

internal class HomeAppDemoApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@HomeAppDemoApp)

            modules(
                homeAppDemoKoinModule,
                homeDataKoinModule,
                homeDomainKoinModule,
                homeUiKoinModule,
                networkKoinModule,
            )
        }
    }
}
