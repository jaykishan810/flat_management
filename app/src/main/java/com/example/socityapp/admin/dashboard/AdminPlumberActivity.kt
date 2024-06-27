package com.example.socityapp.admin.dashboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.societymanagementsystem.admin.DataModel
import com.example.societymanagementsystem.admin.PlumberModel
import com.example.societymanagementsystem.admin.dashboard.adapter.PlumberAdapter
import com.example.socityapp.Prefs
import com.example.socityapp.admin.form.PlumberFormActivity
import com.example.socityapp.databinding.ActivityAdminPlumberBinding

class AdminPlumberActivity : AppCompatActivity() {
    private lateinit var userAdapter: PlumberAdapter
    private val userList = mutableListOf<DataModel>()

    var prefs: Prefs?=null
    var type=""
    lateinit var binding: ActivityAdminPlumberBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAdminPlumberBinding.inflate(layoutInflater)
        initview()

        setContentView(binding.root)
    }


    override fun onResume() {
        super.onResume()
        initview()
    }
    private fun initview() {
        var userlist=prefs?.getplumber()
        System.out.println("add data"+userlist)

        System.out.println("userList"+userList)
        type=prefs?.getStringValue("usertype").toString()
        val existingList = prefs?.getplumber() as? ArrayList<PlumberModel>?: arrayListOf()

        if (userlist!=null) {
            binding.rvc.isVisible=true
            binding.card.isVisible=false

            existingList?.addAll(userlist!!)

            // Save the updated list back to shared preferences
            prefs?.saveplumber(existingList!!)
            userAdapter = PlumberAdapter(userlist!!)
            binding.rvc.layoutManager = LinearLayoutManager(this)
            binding.rvc.adapter = userAdapter
            userAdapter.update(existingList)
        }else{
            binding.rvc.isVisible=false
            binding.card.isVisible=true
            binding.edtname.text="Name: Sachin Bhai"
            binding.edtnumber.text="Number: 9525612121"
            binding.edtaddress.text="Address:103 maniratnasoc opp loyals school a=narapura ahmedabad,Ahmedabad"
            binding.edtworking.text="Working Hours: 9am-6pm"
        }

        if (type=="student") {
            binding.addgardener.isVisible=false

        }else{
            binding.addgardener.isVisible=true
            binding.addgardener.setOnClickListener {
                startActivity(Intent(this, PlumberFormActivity::class.java))
            }
        }
    }
}