package com.example.socityapp.admin.form

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.societymanagementsystem.admin.DataModel
import com.example.socityapp.Prefs
import com.example.socityapp.admin.dashboard.AdminGardenerActivity
import com.example.socityapp.databinding.ActivityGardenerFormBinding

class GardenerFormActivity : AppCompatActivity() {
    lateinit var binding: ActivityGardenerFormBinding
    var prefs: Prefs?=null
    private var userList = mutableListOf<DataModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityGardenerFormBinding.inflate(layoutInflater)
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
            val user = DataModel(name, number, address, hours)
            var getdata=prefs?.getgardener()
            System.out.println("getdata"+getdata)
            if (getdata?.isNotEmpty() == true) {
                userList = getdata as MutableList<DataModel>

                userList.add(user)

                prefs?.savegardener(userList as List<DataModel> )

            }else{
                userList.add(user)

                prefs?.savegardener(userList as List<DataModel> )
            }
            System.out.println("After save: " + prefs?.getgardener())

            // Display a message indicating successful save (optional)
            Toast.makeText(this, "Data Saved!", Toast.LENGTH_SHORT).show()

            startActivity(Intent(this, AdminGardenerActivity::class.java).putExtra("gardentlistdata",ArrayList(
              userList
            )))
            finish()
        }
    }
}