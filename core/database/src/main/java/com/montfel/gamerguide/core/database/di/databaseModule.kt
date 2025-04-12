package com.montfel.gamerguide.core.database.di

import androidx.room.Room
import com.montfel.gamerguide.core.database.GamerGuideDatabase
import com.montfel.gamerguide.core.database.util.Constants
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            context = get(),
            klass = GamerGuideDatabase::class.java,
            name = Constants.GAMER_GUIDE_DATABASE
        ).build()
    }
    single {
        get<GamerGuideDatabase>().favoritedGamesDao()
    }
}
