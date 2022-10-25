package com.montfel.gamerguide

import android.app.Application
import com.montfel.core.di.repositories
import com.montfel.gamerguide.presentation.viewModels
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class GamerGuideApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@GamerGuideApp)
            modules(viewModels, repositories)
        }
    }
}
