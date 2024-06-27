package com.example.socityapp.admin.form

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.societymanagementsystem.admin.DataModel
import com.example.societymanagementsystem.admin.GloceryModel
import com.example.socityapp.Prefs
import com.example.socityapp.admin.dashboard.GroceryActivity
import com.example.socityapp.databinding.ActivityGroceryFormBinding

class GroceryFormActivity : AppCompatActivity() {
    lateinit var binding: ActivityGroceryFormBinding
    var prefs: Prefs?=null
    private var userList = mutableListOf<GloceryModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityGroceryFormBinding.inflate(layoutInflater)
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
            val user = GloceryModel(name, number, address, hours)
            var getdata=prefs?.getglocery()
            System.out.println("getdata"+getdata)
            if (getdata?.isNotEmpty() == true) {
                userList = getdata as MutableList<GloceryModel>

                userList.add(user)

                prefs?.savegrocery(userList as List<GloceryModel> )

            }else{
                userList.add(user)

                prefs?.savegrocery(userList as List<GloceryModel> )
            }
            // Display a message indicating successful save (optional)
            Toast.makeText(this, "Data Saved!", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, GroceryActivity::class.java))
            finish()
        }
    }
}