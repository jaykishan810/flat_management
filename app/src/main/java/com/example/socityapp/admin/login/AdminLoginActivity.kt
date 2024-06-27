package com.example.socityapp.admin.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.socityapp.Prefs
import com.example.socityapp.admin.dashboard.AdminDashboardActivity
import com.example.socityapp.databinding.ActivityAdminLoginBinding


class AdminLoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityAdminLoginBinding
    var prefs:Prefs?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAdminLoginBinding.inflate(layoutInflater)
        initview()
        prefs=Prefs(this)
        setContentView(binding.root)
    }
    fun checkCredentials(username: String, password: String): Boolean {
        // Replace these with your actual default username and password
        val defaultUsername = "admin"
        val defaultPassword = "admin123"

        // Check if the entered credentials match the default values
        return username == defaultUsername && password == defaultPassword
    }

    fun onLoginButtonClicked() {

        val username = binding.edno6.text.toString()
        val password = binding.edno7.text.toString()

        loginUser(username, password)
    }
    private fun initview() {


        binding.btnadmin.setOnClickListener {
            onLoginButtonClicked()
        }
    }

    private fun loginUser(username: String, password: String) {
        // Replace these with your actual default username and password
        val defaultUsername = "admin"
        val defaultPassword = "password123"

        if (username == defaultUsername && password == defaultPassword) {
            // Successful login, navigate to the main part of your app
            // For simplicity, just display a toast message
            prefs?.setStringValue("usertype","admin")
            startActivity(Intent(this, AdminDashboardActivity::class.java))

        } else {
            Toast.makeText(this, "invalid login", Toast.LENGTH_SHORT).show()
            // Display an error message indicating invalid credentials
        }
    }
}