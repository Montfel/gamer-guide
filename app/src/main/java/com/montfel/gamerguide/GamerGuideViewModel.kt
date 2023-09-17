package com.montfel.gamerguide

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.montfel.data.dataSource.remote.remoteConfig.RemoteConfigDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
internal class GamerGuideViewModel @Inject constructor(
    private val remoteConfigDataSource: RemoteConfigDataSource
) : ViewModel() {
    init {
        viewModelScope.launch {
            remoteConfigDataSource.init()
        }
    }
}
