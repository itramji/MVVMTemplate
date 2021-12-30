package com.bornbytes.mybaseapplication.repository

import com.bornbytes.mybaseapplication.api.BaseApi

class AuthRepository(val api: BaseApi) : BaseRepository() {

    suspend fun loginUser() = safeRemoteCall { api.loginUser() }
}