package com.montfel.gamerguide.feature.home.domain.usecase

import androidx.paging.PagingData
import com.montfel.gamerguide.feature.home.domain.model.Game
import kotlinx.coroutines.flow.Flow

interface GetGamesUseCase {
    operator fun invoke(query: String): Flow<PagingData<Game>>
}
