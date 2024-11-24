package com.stores.clothes.ui.scence.auth.verify.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stores.clothes.data.datastore.AuthLocaleRepo
import com.stores.clothes.data.model.auth.requests.LoginRequest
import com.stores.clothes.data.model.auth.requests.ResendVerifyCodeRequest
import com.stores.clothes.data.model.auth.requests.VerifyRequest
import com.stores.clothes.data.model.auth.response.User
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

class VerifyViewModel(private val authRepo: AuthRepo, private val authLocalRepo : AuthLocaleRepo):ViewModel() {
    var verifyResponse= MutableStateFlow<UiState<User>>(UiState.IDLE)
        private  set
    var resendResponse= MutableStateFlow<UiState<String>>(UiState.IDLE)
        private  set
    var countryId:String = ""
    var mobile:String = ""
    val verificationCode = InputWrapper("", Validators::validateCode)

    var isFormValid: MutableState<Boolean> = mutableStateOf(false)
        private set

    init {
        observeVerifyForm()
    }

    private fun observeVerifyForm() {
        viewModelScope.launch {
            verificationCode.isValid.collect { isValid ->
                isFormValid.value = isValid
            }
        }
    }



    fun verify(){
        viewModelScope.launch {
            verifyResponse.value = UiState.Loading
            authRepo.verify(VerifyRequest(mobile = mobile, countryId = countryId, code = verificationCode.value))
                .onSuccess {data ->
                    verifyResponse.value = UiState.Success(data.user)
                    authLocalRepo.updateUser(data.user)
                    authLocalRepo.updateAccessTokenLaunch(data.user.accessToken ?:"")
                }
                .onError {error ->
                    verifyResponse.value = UiState.Error(error.name)
                    log(error.name)
                }
        }
    }


    fun resend(){
        viewModelScope.launch {
            resendResponse.value = UiState.Loading
            authRepo.resendCode(ResendVerifyCodeRequest (mobile = mobile, countryId = countryId))
                .onSuccess {data ->
                    resendResponse.value = UiState.Success(data.responseMessage)
                }
                .onError {error ->
                    resendResponse.value = UiState.Error(error.name)
                    log(error.name)
                }
        }
    }
}