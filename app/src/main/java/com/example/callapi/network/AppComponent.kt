package com.example.callapi.network

import com.example.callapi.MainActivity
import dagger.Component

// thông báo cho dagger sẽ sử dụng networkmodule để cung cấp dependence
@Component(modules = [NetworkModule::class])

interface AppComponent {
    fun injectActivity(activity: MainActivity)
}