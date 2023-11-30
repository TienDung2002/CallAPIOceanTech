package com.example.callapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.callapi.adapter.MyAdapter
import com.example.callapi.databinding.ActivityMainBinding
import com.example.callapi.network.ExerciseApplication
import com.example.callapi.viewmodel.MyViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    @Inject
    lateinit var viewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val appComponent = (application as ExerciseApplication).appComponent
        appComponent.injectActivity(this)


        val adapter = MyAdapter(emptyList())
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter


        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        viewModel.getUsersLiveData().observe(this) { userList ->
            adapter.setData(userList)
        }
    }
}