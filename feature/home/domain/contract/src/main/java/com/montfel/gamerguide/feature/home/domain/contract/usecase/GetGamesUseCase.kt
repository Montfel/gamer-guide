package com.montfel.gamerguide.feature.home.domain.contract.usecase

import androidx.paging.PagingData
import com.montfel.gamerguide.feature.home.domain.contract.model.Game
import kotlinx.coroutines.flow.Flow

interface GetGamesUseCase {
    operator fun invoke(): Flow<PagingData<Game>>
}
