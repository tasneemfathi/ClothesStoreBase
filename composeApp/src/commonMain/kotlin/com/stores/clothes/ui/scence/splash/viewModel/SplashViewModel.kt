package com.stores.clothes.ui.scence.splash.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stores.clothes.data.datastore.AppLocaleConfigRepo
import com.stores.clothes.data.datastore.AuthLocaleRepo
import com.stores.clothes.data.model.auth.response.User
import com.stores.clothes.data.networking.repo.ConfigRepo
import com.stores.clothes.data.networking.utils.onError
import com.stores.clothes.data.networking.utils.onSuccess
import com.stores.clothes.di.localRepoModule
import com.stores.clothes.utils.log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class SplashViewModel(private val localConfigRepo: AppLocaleConfigRepo, private val authLocalRepo: AuthLocaleRepo, private val remoteConfigRepo:ConfigRepo) : ViewModel() {

    val isFirstLaunch: Flow<Boolean> = localConfigRepo.isFirstLaunch
    val isUserNotLoggedIn: Flow<Boolean> = authLocalRepo.user.map { it == null }

    init {
        getConfig()
        getCountries()

    }

    private fun getConfig() {
        viewModelScope.launch {
            remoteConfigRepo.getConfig()
                .onSuccess {
                    localConfigRepo.updateAppConfig(config = it.configurations)
                }
                .onError { error ->
                    log(error.name)
                }
        }
    }

    private fun getCountries() {
        viewModelScope.launch {
            remoteConfigRepo.getCountries()
                .onSuccess {
                    localConfigRepo.updateAppCountries(countries = it.countries)
                }
                .onError { error ->
                    log(error.name)
                }
        }
    }

}