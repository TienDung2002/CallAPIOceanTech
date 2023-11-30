package com.example.callapi.network

import com.example.callapi.MainActivity
import dagger.Component

// thông báo cho dagger sẽ sử dụng networkmodule để cung cấp dependence
@Component(modules = [NetworkModule::class])

interface AppComponent {
    // sử dụng hàm này để dagger tìm nơi inject dependency vào
    fun injectActivity(activity: MainActivity)
}