package com.example.callapi.network

import android.app.Application
import javax.inject.Inject

class ExerciseApplication : Application() {
    @Inject
    lateinit var appComponent: AppComponent

    override fun onCreate(){
        initializeDagger()
        super.onCreate()
    }

    private fun initializeDagger(){
        appComponent = DaggerAppComponent.create()
    }
}