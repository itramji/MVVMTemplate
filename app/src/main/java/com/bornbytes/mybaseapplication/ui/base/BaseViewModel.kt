package com.bornbytes.mybaseapplication.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bornbytes.mybaseapplication.api.BaseApi
import com.bornbytes.mybaseapplication.repository.BaseRepository
import kotlinx.coroutines.launch

open class BaseViewModel(val baseRepository: BaseRepository) : ViewModel() {

    fun logoutUser(api: BaseApi) = viewModelScope.launch {
        baseRepository.logoutUser(api)
    }
}