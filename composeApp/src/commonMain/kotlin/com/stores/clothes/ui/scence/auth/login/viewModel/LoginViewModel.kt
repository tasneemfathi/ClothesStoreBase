package com.stores.clothes.ui.scence.auth.login.viewModel


import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stores.clothes.data.datastore.AppLocaleConfigRepo
import com.stores.clothes.data.datastore.AuthLocaleRepo
import com.stores.clothes.data.model.auth.requests.LoginRequest
import com.stores.clothes.data.model.auth.response.User
import com.stores.clothes.data.model.config.countries.Country
import com.stores.clothes.data.networking.repo.AuthRepo
import com.stores.clothes.data.networking.utils.UiState
import com.stores.clothes.data.networking.utils.onError
import com.stores.clothes.data.networking.utils.onSuccess
import com.stores.clothes.utils.log
import com.stores.clothes.utils.validator.Validators
import com.stores.clothes.utils.wrapper.InputWrapper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.launch


class LoginViewModel (private val authRepo: AuthRepo, private val localRepo: AppLocaleConfigRepo, private val authLocalRepo: AuthLocaleRepo) : ViewModel() {
     var authResponse= MutableStateFlow<UiState<User>>(UiState.IDLE)
         private  set

    val usernameField = InputWrapper("", Validators::validateRequired)
    val mobileField = InputWrapper("", Validators::validateMobile)

    var isFormValid: MutableState<Boolean> = mutableStateOf(false)
        private set

    var countries:MutableStateFlow<List<Country>> = MutableStateFlow(mutableListOf())

    var countryId = MutableStateFlow("1")

    init {
        observeLoginForm()
        getCountries()
    }

    private fun observeLoginForm() {
        viewModelScope.launch {
            combine(
                usernameField.isValid.drop(1),
                mobileField.isValid.drop(1)
            ) { usernameValid, mobileValid ->
                usernameValid && mobileValid
            }.drop(1).collect { isValid ->
                isFormValid.value = isValid
            }
        }
    }

    private fun getCountries(){
        viewModelScope.launch {
            localRepo.countries.collect{
                countries.value = it
            }
        }
    }

    fun login(){
        viewModelScope.launch {
            authResponse.value = UiState.Loading
            authRepo.login(LoginRequest(name = usernameField.value, mobile = mobileField.value, countryId = countryId.value))
                .onSuccess {data ->
                    authResponse.value = UiState.Success(data.user)
                    if(data.user.isUserEnabled){ authLocalRepo.updateUser(data.user)}
                }
                .onError {error ->
                    authResponse.value = UiState.Error(error.name)
                    log(error.name)
                }
        }
    }

}
