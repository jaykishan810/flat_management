package com.example.socityapp.admin.dashboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.socityapp.databinding.ActivityAdminDashboardBinding

class AdminDashboardActivity : AppCompatActivity() {
    lateinit var bindig: ActivityAdminDashboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindig= ActivityAdminDashboardBinding.inflate(layoutInflater)
        bindig.i1.setOnClickListener {
            startActivity(Intent(this,AdminServiceActivity::class.java))
        }
        bindig.i2.setOnClickListener {
            startActivity(Intent(this,AdminFestivalActivity::class.java))

        }

        setContentView(bindig.root)
    }
}