package com.montfel.gamerguide.feature.lists.domain.implementation.di

import com.montfel.gamerguide.feature.lists.domain.contract.usecase.FavoriteGameUseCase
import com.montfel.gamerguide.feature.lists.domain.contract.usecase.IsFavoritedGameUseCase
import com.montfel.gamerguide.feature.lists.domain.contract.usecase.UnfavoriteGameUseCase
import com.montfel.gamerguide.feature.lists.domain.implementation.usecase.FavoriteGameUseCaseImpl
import com.montfel.gamerguide.feature.lists.domain.implementation.usecase.IsFavoritedGameUseCaseImpl
import com.montfel.gamerguide.feature.lists.domain.implementation.usecase.UnfavoriteGameUseCaseImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val listsDomainModule = module {
    singleOf(::FavoriteGameUseCaseImpl) bind FavoriteGameUseCase::class
    singleOf(::UnfavoriteGameUseCaseImpl) bind UnfavoriteGameUseCase::class
    singleOf(::IsFavoritedGameUseCaseImpl) bind IsFavoritedGameUseCase::class
}
