package com.example.socityapp.admin.dashboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.societymanagementsystem.admin.DataModel
import com.example.societymanagementsystem.admin.DoctorModel
import com.example.societymanagementsystem.admin.GloceryModel
import com.example.societymanagementsystem.admin.dashboard.adapter.DoctorAdapter
import com.example.socityapp.Prefs
import com.example.socityapp.admin.form.DoctorFormActivity
import com.example.socityapp.databinding.ActivityAdminDoctorBinding

class AdminDoctorActivity : AppCompatActivity() {
    lateinit var binding: ActivityAdminDoctorBinding
    private lateinit var userAdapter: DoctorAdapter
    private val userList = mutableListOf<DoctorModel>()
    var type=""
    var prefs: Prefs?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAdminDoctorBinding.inflate(layoutInflater)
        initview()
        prefs= Prefs(this)
        setContentView(binding.root)
    }

    private fun initview() {


        var userlist=prefs?.getdoctor()
        System.out.println("add data"+userlist)
        type=prefs?.getStringValue("usertype").toString()

        System.out.println("userList"+userList)
        val existingList = prefs?.getdoctor() as? ArrayList<DoctorModel>?: arrayListOf()

        if (userlist!=null) {
            binding.card.isVisible=false
            binding.rvc.isVisible=true
            existingList?.addAll(userlist!!)

            // Save the updated list back to shared preferences
            prefs?.savedoctor(existingList!!)
            userAdapter = DoctorAdapter(userlist!!)
            binding.rvc.layoutManager = LinearLayoutManager(this)
            binding.rvc.adapter = userAdapter
            userAdapter.update(existingList)
        }else{
            binding.rvc.isVisible=false
            binding.card.isVisible=true
            binding.edtname.text="Name: Suresh Bhai"
            binding.edtnumber.text="Number: 9529656561"
            binding.edtaddress.text="Address:new ranip,Ahmedabad"
            binding.edtworking.text="Working Hours: 9am-6pm"
        }

        if (type=="student") {
            binding.addgardener.isVisible=false

        }else{
            binding.addgardener.isVisible=true
            binding.addgardener.setOnClickListener {
                startActivity(Intent(this, DoctorFormActivity::class.java))
            }
        }
    }
}