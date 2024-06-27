package com.example.socityapp.user.dashboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.socityapp.PaymentActivity
import com.example.socityapp.Prefs
import com.example.socityapp.RegisterActivity
import com.example.socityapp.admin.dashboard.AdminFestivalActivity
import com.example.socityapp.admin.dashboard.AdminServiceActivity
import com.example.socityapp.databinding.ActivityUserDashboardBinding

class UserDashboardActivity : AppCompatActivity() {
    lateinit var bindig: ActivityUserDashboardBinding
    var prefs:Prefs?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindig= ActivityUserDashboardBinding.inflate(layoutInflater)
        prefs=Prefs(this)
        bindig.i1.setOnClickListener {
            startActivity(Intent(this, AdminServiceActivity::class.java))
        }
        bindig.i2.setOnClickListener {
            startActivity(Intent(this, AdminFestivalActivity::class.java))

        }

            bindig.i3.setOnClickListener {
               startActivity(Intent(this, PaymentActivity::class.java))

            }

        bindig.text2.setOnClickListener {
            prefs?.clear()
            startActivity(Intent(this,RegisterActivity::class.java))

        }

        setContentView(bindig.root)
    }
}