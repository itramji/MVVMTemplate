package com.bornbytes.mybaseapplication.api

import retrofit2.http.POST

interface BaseApi {

    @POST("/auth")
    suspend fun loginUser(): Any

    @POST("/logout")
    suspend fun logoutUser(): Any
}