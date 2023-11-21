package com.example.callapi.data

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


private val BASE_URL = "https://randomuser.me/"
private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

object ApiServiceManager  {
    // chỉ khởi tạo khi sử dụng tới
    val retrofitService: APIController by lazy {
        retrofit.create(APIController::class.java)
    }
}

interface APIController {
    @GET("/api/?results=20")
    suspend fun getUsers(): Call<FullData>
}



