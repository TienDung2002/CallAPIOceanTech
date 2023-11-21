package com.example.callapi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.callapi.R
import com.example.callapi.data.User
import com.example.callapi.viewmodel.UserViewModel

class MyAdapter(private val datalist: List<User>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var TV_name: TextView
        private var TV_email: TextView
        private var TV_gender : TextView
        private var TV_location : TextView
        private var TV_phone : TextView
        private var TV_nat : TextView

        init {
            TV_name = view.findViewById(R.id.tvName)
            TV_email = view.findViewById(R.id.tvEmail)
            TV_gender = view.findViewById(R.id.tvGender)
            TV_location = view.findViewById(R.id.tvLocation)
            TV_phone = view.findViewById(R.id.tvPhone)
            TV_nat = view.findViewById(R.id.tvNat)
        }

        fun bind(data: User){
            with(data){
//                TV_name.text = "${name.title} ${name.first} ${name.last}"
                TV_name.text = resources.getString()
                TV_gender.text = "Gender: " + "${gender}"
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = datalist.size

}