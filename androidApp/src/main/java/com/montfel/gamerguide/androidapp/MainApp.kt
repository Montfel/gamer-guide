package com.montfel.gamerguide.androidapp

import android.app.Application
import com.montfel.gamerguide.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

internal class MainApp : Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidLogger()
            androidContext(this@MainApp)
        }
    }
}
