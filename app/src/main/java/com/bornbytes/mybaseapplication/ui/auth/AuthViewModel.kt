package com.bornbytes.mybaseapplication.ui.auth

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.bornbytes.mybaseapplication.api.RemoteResult
import com.bornbytes.mybaseapplication.repository.AuthRepository
import com.bornbytes.mybaseapplication.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class AuthViewModel(val authRepository: AuthRepository) : BaseViewModel(authRepository) {

    val loginResponse = MutableLiveData<RemoteResult<Any>>()

    fun loginUser() = viewModelScope.launch {
        loginResponse.value = authRepository.loginUser()
    }
}