package com.example.socityapp.admin.form

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.societymanagementsystem.admin.DoctorModel
import com.example.societymanagementsystem.admin.GloceryModel
import com.example.socityapp.Prefs
import com.example.socityapp.admin.dashboard.AdminDoctorActivity
import com.example.socityapp.admin.dashboard.AdminGardenerActivity
import com.example.socityapp.databinding.ActivityDoctorFormBinding

class DoctorFormActivity : AppCompatActivity() {
    lateinit var binding: ActivityDoctorFormBinding
    var prefs: Prefs?=null
    private var userList = mutableListOf<DoctorModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDoctorFormBinding.inflate(layoutInflater)
        initview()
        prefs= Prefs(this)
        getdata()
        setContentView(binding.root)
    }

    private fun getdata() {

    }

    private fun initview() {
        binding.add.setOnClickListener {
            var name = binding.edtname.text.toString()
            var address = binding.edtaddress.text.toString()
            var number = binding.edtnumber.text.toString()
            var hours = binding.edtwork.text.toString()
            val user = DoctorModel(name, number, address, hours)
            var getdata=prefs?.getdoctor()
            System.out.println("getdata"+getdata)
            if (getdata?.isNotEmpty() == true) {
                userList = getdata as MutableList<DoctorModel>

                userList.add(user)

                prefs?.savedoctor(userList as List<DoctorModel> )

            }else{
                userList.add(user)

                prefs?.savedoctor(userList as List<DoctorModel> )
            }
            // Display a message indicating successful save (optional)
            Toast.makeText(this, "Data Saved!", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, AdminDoctorActivity::class.java))
            finish()
        }
    }
}