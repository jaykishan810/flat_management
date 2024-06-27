package com.example.socityapp.admin.form

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.societymanagementsystem.admin.DataModel
import com.example.societymanagementsystem.admin.PlumberModel
import com.example.socityapp.Prefs
import com.example.socityapp.admin.dashboard.AdminPlumberActivity
import com.example.socityapp.databinding.ActivityPlumberFormBinding


class PlumberFormActivity : AppCompatActivity() {
    lateinit var binding: ActivityPlumberFormBinding
    var prefs: Prefs?=null
    private var userList = mutableListOf<PlumberModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityPlumberFormBinding.inflate(layoutInflater)
        initview()
        prefs= Prefs(this)
        getdata()
        setContentView(binding.root)
    }

    private fun getdata() {
        val existingUser = prefs?.getgardener()
        if (existingUser != null) {

        }
    }

    private fun initview() {
        binding.add.setOnClickListener {
            var name = binding.edtname.text.toString()
            var address = binding.edtaddress.text.toString()
            var number = binding.edtnumber.text.toString()
            var hours = binding.edtwork.text.toString()
            val user = PlumberModel(name, number, address, hours)
            var getdata=prefs?.getplumber()

            System.out.println("Before save: " + user)

            if (getdata?.isNotEmpty() == true) {
            userList = getdata as MutableList<PlumberModel>

            userList.add(user)

            prefs?.saveplumber(userList as List<PlumberModel> )

        }else{
            userList.add(user)

            prefs?.saveplumber(userList as List<PlumberModel> )
        }
            // Display a message indicating successful save (optional)
            Toast.makeText(this, "Data Saved!", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, AdminPlumberActivity::class.java))
            finish()
        }
    }
}