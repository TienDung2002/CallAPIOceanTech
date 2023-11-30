package com.example.callapi.network

import android.app.Application
import javax.inject.Inject

class ExerciseApplication : Application() {
    @Inject // đánh dấu inject để dagger tự động inject nó vào đích đến
    lateinit var appComponent: AppComponent

    override fun onCreate(){
        initializeDagger()
        super.onCreate()
    }

    private fun initializeDagger(){
        appComponent = DaggerAppComponent.create()
    }
}