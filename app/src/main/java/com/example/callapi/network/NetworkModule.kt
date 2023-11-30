package com.example.callapi.network

import com.example.callapi.data.APIController
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
object NetworkModule {
    // 2 module cung cấp dependencies
    @Provides
    @Singleton // đánh dấu rằng hàm dc tạo ra 1 lần trong suốt vòng đời của UD
    fun provideRetroService(): Retrofit{
        val BASE_URL = "https://randomuser.me/"
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Provides
    @Singleton
    fun provideApiUser(retrofit: Retrofit): APIController {
        return retrofit.create(APIController::class.java)
    }
}