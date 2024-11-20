package com.stores.clothes.ui.scence.splash.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stores.clothes.data.datastore.AppLocaleConfigRepo
import com.stores.clothes.data.networking.repo.ConfigRepo
import com.stores.clothes.data.networking.utils.onError
import com.stores.clothes.data.networking.utils.onSuccess
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class SplashViewModel(localConfigRepo: AppLocaleConfigRepo,val remoteConfigRepo:ConfigRepo) : ViewModel() {

    val isFirstLaunch : Flow<Boolean> = localConfigRepo.isFirstLaunch

    init {

    }
    fun getConfig(){
        viewModelScope.launch {
            remoteConfigRepo.getConfig()
                .onSuccess {  }
                .onError {  }
        }
    }
}