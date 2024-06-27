package com.example.socityapp.admin.dashboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.socityapp.ChristmasActivity
import com.example.socityapp.DiwaliActivity
import com.example.socityapp.UttarayanActivity
import com.example.socityapp.admin.NavratriActivity
import com.example.socityapp.databinding.ActivityAdminFestivalBinding


class AdminFestivalActivity : AppCompatActivity() {
    lateinit var binding: ActivityAdminFestivalBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAdminFestivalBinding.inflate(layoutInflater)
        initview()
        setContentView(binding.root)
    }

    private fun initview() {

        binding.img6.setOnClickListener {
            startActivity(Intent(this, NavratriActivity::class.java))
        }
        binding.img7.setOnClickListener {
            startActivity(Intent(this, DiwaliActivity::class.java))
        }
        binding.img8.setOnClickListener {
            startActivity(Intent(this, ChristmasActivity::class.java))
        }
        binding.img9.setOnClickListener {
            startActivity(Intent(this, UttarayanActivity::class.java))
        }
    }
}