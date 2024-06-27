package com.example.socityapp.admin.dashboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.socityapp.databinding.ActivityAdminServiceBinding

class AdminServiceActivity : AppCompatActivity() {
    lateinit var binding: ActivityAdminServiceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAdminServiceBinding.inflate(layoutInflater)
        initview()
        setContentView(binding.root)
    }

    private fun initview() {
        binding.img1.setOnClickListener {
            startActivity(Intent(this,AdminGardenerActivity::class.java))
        }

        binding.img2.setOnClickListener {
            startActivity(Intent(this,AdminPlumberActivity::class.java))
        }

        binding.img3.setOnClickListener {
            startActivity(Intent(this,GroceryActivity::class.java))
        }

        binding.img4.setOnClickListener {
            startActivity(Intent(this,AdminDoctorActivity::class.java))
        }

    }
}