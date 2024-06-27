package com.example.societymanagementsystem.admin.dashboard.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.societymanagementsystem.admin.DataModel
import com.example.societymanagementsystem.admin.GloceryModel
import com.example.societymanagementsystem.admin.PlumberModel
import com.example.socityapp.R

class GroceryAdapter(private var userList: List<GloceryModel>) :
    RecyclerView.Adapter<GroceryAdapter.UserViewHolder>() {

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.edtname)
        val addressTextView: TextView = itemView.findViewById(R.id.edtaddress)
        val phoneNumberTextView: TextView = itemView.findViewById(R.id.edtnumber)
        val working: TextView = itemView.findViewById(R.id.edtworking)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_getdataservice, parent, false)
        return UserViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentUser = userList[position]

        // Bind user data to the views
        holder.nameTextView.text = "Name: ${currentUser.name}"
        holder.addressTextView.text = "Address: ${currentUser.address}"
        holder.phoneNumberTextView.text = "Phone Number: ${currentUser.number}"
        holder.working.text = "Working Hours: ${currentUser.hours}"
    }
    fun update(temp:List<GloceryModel>){
        userList=temp
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
        return userList.size
    }
}