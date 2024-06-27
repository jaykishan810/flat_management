package com.example.socityapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.socityapp.admin.login.AdminLoginActivity
import com.example.socityapp.databinding.ActivityLoginBinding
import com.example.socityapp.user.dashboard.UserDashboardActivity


class LoginActivity : AppCompatActivity() {
    var prefs: Prefs?=null
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        initview()
        prefs=Prefs(this)

        setContentView(binding.root)
    }

    private fun initview() {
        System.out.println("User"+prefs?.getStringValue("username"))
        System.out.println("Password"+prefs?.getStringValue("password"))
        binding.adminlogin.setOnClickListener {
            startActivity(Intent(this, AdminLoginActivity::class.java))
        }
        binding.btnans3.setOnClickListener {
            var username=binding.edno6.text.toString()
            var password=binding.edno7.text.toString()
            if (username.isEmpty() ){
                binding.edno6.error="Enter Your name"
            }
            else if(password.isEmpty()){
                binding.edno7.error="Enter Your name"

            }else{
                var getmodel=prefs?.getregister()
                var validator=false
                if (getmodel != null) {
                    for (i in getmodel){
                        if (i.name==username && i.password==password){
                            validator=true
                        }
                    }
                        if (validator){
                            prefs?.setStringValue("usertype","student")

                            startActivity(Intent(this, UserDashboardActivity::class.java))
                        }else{
                            Toast.makeText(this, "Invalid Login", Toast.LENGTH_SHORT).show()
                        }
                }

            }
        }
    }
}