package com.example.callapi.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.callapi.data.APIController
import com.example.callapi.data.FullData
import com.example.callapi.data.User
import com.example.callapi.network.NetworkModule
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class MyViewModel : ViewModel() {
    private val listData : MutableLiveData<List<User>> = MutableLiveData()
    private lateinit var getAPIUsers : APIController

    fun getUsersLiveData(): LiveData<List<User>> {
        initData()
        return listData
    }
    private fun initData() {
        viewModelScope.launch {
            try {
//                ApiServiceManager.retrofitService.getUsers().enqueue(object : Callback<FullData> {
                getAPIUsers = NetworkModule.provideApiUser(NetworkModule.provideRetroService())

                getAPIUsers.getUsers().enqueue(object : Callback<FullData> {
                    override fun onResponse(call: Call<FullData>, response: Response<FullData>) {
                        if (response.isSuccessful) {
                            listData.value = response.body()?.results
                            Log.d("onResponse","Lấy dữ liệu thành công")
                        }
                        Log.d("onResponse","hàm đã chạy tới đây")
                    }
                    override fun onFailure(call: Call<FullData>, t: Throwable) {
                        Log.d("onFailure","Lấy dữ liệu thất bại")
                    }
                })
            } catch (e: IOException) {
                Log.d("error", "Kết nối tới API thất bại")
            }
        }
    }
}