package com.example.callapi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.callapi.R
import com.example.callapi.data.User
import com.squareup.picasso.Picasso

class MyAdapter(private var dataList: List<User>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var TV_name: TextView
        private var TV_email: TextView
        private var TV_gender : TextView
        private var TV_location : TextView
        private var TV_timezone : TextView
        private var TV_phone : TextView
        private var TV_nat : TextView
        private var ImgV_avatar: ImageView

        init {
            TV_name = view.findViewById(R.id.tvName)
            TV_email = view.findViewById(R.id.tvEmail)
            TV_gender = view.findViewById(R.id.tvGender)
            TV_location = view.findViewById(R.id.tvLocation)
            TV_timezone = view.findViewById(R.id.tvTimezone)
            TV_phone = view.findViewById(R.id.tvPhone)
            TV_nat = view.findViewById(R.id.tvNat)
            ImgV_avatar = view.findViewById(R.id.user_picture)
        }

        fun bind(data: User){
            with(data){
                TV_name.text = itemView.context.getString(R.string.tvname, name.title, name.first, name.last)
                TV_email.text = itemView.context.getString(R.string.tvemail, email)
                TV_gender.text = itemView.context.getString(R.string.tvgender, gender)
                TV_location.text = itemView.context.getString(R.string.tvlocation, location.street.name, location.city, location.state, location.country)
                TV_timezone.text = itemView.context.getString(R.string.tvtimezone, location.timezone.offset, location.timezone.description)
                TV_phone.text = itemView.context.getString(R.string.tvphone, phone)
                TV_nat.text = itemView.context.getString(R.string.tvnat, nat)
                // user avatar
                Picasso.get().load(picture.medium).into(ImgV_avatar)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int = dataList.size

    fun setData(newDataList: List<User>) {
        dataList = newDataList
        notifyDataSetChanged()
    }
}