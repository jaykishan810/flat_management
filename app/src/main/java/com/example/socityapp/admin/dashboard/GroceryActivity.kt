package com.example.socityapp.admin.dashboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.societymanagementsystem.admin.DataModel
import com.example.societymanagementsystem.admin.GloceryModel
import com.example.societymanagementsystem.admin.PlumberModel
import com.example.societymanagementsystem.admin.dashboard.adapter.GroceryAdapter

import com.example.socityapp.Prefs
import com.example.socityapp.admin.form.GroceryFormActivity
import com.example.socityapp.databinding.ActivityGroceryBinding

class GroceryActivity : AppCompatActivity() {
    private lateinit var userAdapter: GroceryAdapter
    private val userList = mutableListOf<DataModel>()
    var type=""
    var prefs: Prefs?=null
    lateinit var binding: ActivityGroceryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityGroceryBinding.inflate(layoutInflater)
        initview()

        setContentView(binding.root)
    }

    private fun initview() {
        var userlist=prefs?.getglocery()
        System.out.println("add data"+userlist)

        System.out.println("userList"+userList)
        type=prefs?.getStringValue("usertype").toString()
        val existingList = prefs?.getplumber() as? ArrayList<GloceryModel>?: arrayListOf()

        if (userlist!=null) {
            binding.card.isVisible=false
            binding.rvc.isVisible=true
            existingList?.addAll(userlist!!)

            // Save the updated list back to shared preferences
            prefs?.savegrocery(existingList!!)
            userAdapter = GroceryAdapter(userlist!!)
            binding.rvc.layoutManager = LinearLayoutManager(this)
            binding.rvc.adapter = userAdapter
            userAdapter.update(existingList)
        }else{
            binding.card.isVisible=true
            binding.rvc.isVisible=false
            binding.edtname.text="Name: Ramesh Bhai"
            binding.edtnumber.text="Number: 9525656561"
            binding.edtaddress.text="Address:103 vegetable mart opp kids world m=naranpura ahmedabad,Ahmedabad"
            binding.edtworking.text="Working Hours: 9am-6pm"
        }

        if (type=="student") {
            binding.addgardener.isVisible=false

        }else{
            binding.addgardener.isVisible=true
            binding.addgardener.setOnClickListener {
                startActivity(Intent(this, GroceryFormActivity::class.java))
            }
        }
    }}