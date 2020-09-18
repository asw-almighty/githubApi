package com.example.githubapi

import retrofit2.Call
import retrofit2.http.GET

interface API {
    @GET("users?q=himchanyoon")
    fun getUsers() : Call<UserData>
}