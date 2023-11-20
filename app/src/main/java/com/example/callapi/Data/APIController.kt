package com.example.callapi.Data

import retrofit2.Call
import retrofit2.http.GET

interface APIController {
    @GET("/api/?results=20")
    fun getUsers(): Call<FullData>
}