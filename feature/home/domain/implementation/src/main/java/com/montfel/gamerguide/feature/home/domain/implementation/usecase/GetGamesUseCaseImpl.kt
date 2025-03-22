package com.montfel.gamerguide.feature.home.domain.implementation.usecase

import androidx.paging.PagingData
import androidx.paging.map
import com.montfel.gamerguide.feature.home.data.contract.model.GameData
import com.montfel.gamerguide.feature.home.data.contract.repository.HomeRepository
import com.montfel.gamerguide.feature.home.domain.contract.model.Game
import com.montfel.gamerguide.feature.home.domain.contract.usecase.GetGamesUseCase
import com.montfel.gamerguide.feature.home.domain.implementation.mapper.toGame
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetGamesUseCaseImpl(
    private val homeRepository: HomeRepository
) : GetGamesUseCase {
    override operator fun invoke(): Flow<PagingData<Game>> {
        return homeRepository.getGames().map { it.map(GameData::toGame) }
    }
}
