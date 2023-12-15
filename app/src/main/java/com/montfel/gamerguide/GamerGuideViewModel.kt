package com.montfel.gamerguide

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.montfel.gamerguide.feature.data.datasource.remote.remoteConfig.RemoteConfigDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
internal class GamerGuideViewModel @Inject constructor(
    private val remoteConfigDataSource: RemoteConfigDataSource,
) : ViewModel() {

    var isLoading by mutableStateOf(true)

    init {
        var result: Boolean?

        viewModelScope.launch {
            result = remoteConfigDataSource.init()

            result?.let {
                isLoading = false
            }
        }
    }
}
