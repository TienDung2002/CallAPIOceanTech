package com.example.callapi.Data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


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

private fun getUsers(): MutableLiveData<List<User>> {
    val data = MutableLiveData<List<User>>()
    ApiServiceManager.retrofitService.getUsers().enqueue(object : Callback<FullData> {
        override fun onResponse(call: Call<FullData>, response: Response<FullData>) {
            if (response.isSuccessful) {
                data.value = response.body()?.results
                Log.d("onResponse","Thành công 1")
            }
            Log.d("onResponse","Thành công 2")
        }

        override fun onFailure(call: Call<FullData>, t: Throwable) {
            Log.d("onFailure","Lấy dữ liệu thất bại")
        }
    })
    return data
}



