package com.montfel.gamerguide.feature.home.domain.usecase

import androidx.paging.PagingData
import com.montfel.gamerguide.feature.home.domain.model.Game
import com.montfel.gamerguide.feature.home.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow

class GetGamesUseCaseImpl(
    private val homeRepository: HomeRepository
) : GetGamesUseCase {
    override operator fun invoke(query: String): Flow<PagingData<Game>> {
        return homeRepository.getGames(query = query)
    }
}
