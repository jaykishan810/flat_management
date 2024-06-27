package com.example.socityapp.admin.dashboard

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.societymanagementsystem.admin.DataModel
import com.example.societymanagementsystem.admin.dashboard.adapter.GardenerAdapter
import com.example.socityapp.Prefs
import com.example.socityapp.admin.form.GardenerFormActivity
import com.example.socityapp.databinding.ActivityAdminGardenerBinding


class AdminGardenerActivity : AppCompatActivity() {
    lateinit var binding: ActivityAdminGardenerBinding
    private lateinit var userAdapter: GardenerAdapter
    private val userList = mutableListOf<DataModel>()
    var type=""
    var prefs:Prefs?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAdminGardenerBinding.inflate(layoutInflater)
        initview()
        prefs= Prefs(this)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        initview()
    }
    private fun initview() {

        binding.deletgardener.setOnClickListener {
            prefs?.remove("gardener")
            Toast.makeText(this, "clear data", Toast.LENGTH_SHORT).show()
        }
        binding.edtnumber.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:0123456789")
            startActivity(intent)
        }
        var userlist=prefs?.getgardener()
        System.out.println("add data"+userlist)

       // val userList = intent.getSerializableExtra("gardentlistdata") as? ArrayList<DataModel>
        System.out.println("userList"+userList)
        type=prefs?.getStringValue("usertype").toString()

        val existingList = prefs?.getgardener() as? ArrayList<DataModel>?: arrayListOf()

        if (userlist!=null) {
            binding.rvc.isVisible=true
            binding.card.isVisible=false

            // Combine existing data with new data
            existingList?.addAll(userlist!!)

            // Save the updated list back to shared preferences
            prefs?.savegardener(existingList!!)
            binding.rvc.layoutManager = LinearLayoutManager(this)

            userAdapter = GardenerAdapter(existingList!!){
               /* val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse("tel:$it.number")
                startActivity(intent)*/
            }
            binding.rvc.adapter = userAdapter

            userAdapter.update(existingList)


        }else{
            binding.addgardener.isVisible=false
            binding.rvc.isVisible=false
            binding.card.isVisible=true
            binding.edtname.text="Name: Ravi Bhai"
            binding.edtnumber.text="9695612121"
            binding.edtaddress.text="Address: Sindhubhavan Road,Ahmedabad"
            binding.edtworking.text="Working Hours: 9am-6pm"
        }
        if (type=="student") {
            binding.addgardener.isVisible=false


        }else{
            binding.addgardener.setOnClickListener {
                startActivity(Intent(this, GardenerFormActivity::class.java))
            }
            binding.addgardener.isVisible=true

        }
    }
}