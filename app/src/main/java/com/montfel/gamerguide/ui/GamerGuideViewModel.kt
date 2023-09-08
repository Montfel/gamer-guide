package com.montfel.gamerguide.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.montfel.data.dataSource.remote.remoteConfig.RemoteConfigDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class GamerGuideViewModel @Inject constructor(
    private val remoteConfigDataSource: RemoteConfigDataSource
) : ViewModel() {
    fun initRemoteConfig() {
        viewModelScope.launch {
            remoteConfigDataSource.init()
        }
    }
}