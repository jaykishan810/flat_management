package com.example.socityapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText
import com.example.societymanagementsystem.admin.DataModel
import com.example.socityapp.databinding.ActivityRegisterBinding
import com.example.socityapp.user.model.registermodel


class RegisterActivity : AppCompatActivity() {
    var prefs: Prefs?=null
    lateinit var binding: com.example.socityapp.databinding.ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRegisterBinding.inflate(layoutInflater)
        initview()
        prefs=Prefs(this)
        setContentView(binding.root)
    }

    private fun initview() {
        binding.btnans2.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))

        }
        binding.btnans1.setOnClickListener {
            var name=binding.edno1.text.toString()
            var username=binding.edno2.text.toString()
            var number=binding.edno4.text.toString()
            var password=binding.edno5.text.toString()
            var email=binding.edno3.text.toString()
            if (name.isEmpty()){
                binding.edno1.error="Name is required"
                binding.edno1.requestFocus()
            }else if (username.isEmpty()){
                binding.edno2.error="username is required"
                binding.edno2.requestFocus()
            }
            else if (number.isEmpty()){
                binding.edno4.error="number is required"
                binding.edno4.requestFocus()
            }
            else if (password.isEmpty()){
                binding.edno5.error="password is required"
                binding.edno5.requestFocus()
            }
            else if (email.isEmpty()){
                binding.edno3.error="Email is required"
                binding.edno3.requestFocus()
            }
            else if (username==prefs?.getStringValue("username")){
                Toast.makeText(this, "username already exist!", Toast.LENGTH_SHORT).show()
            }
            else if (number.length<10) {
            Toast.makeText(this, "Enter 10 Digits number", Toast.LENGTH_SHORT).show()
        }
                else{
                if(isEmailCorrect(binding?.edno3!!)){
                    binding.edno3.error="Email validation fail"
                    binding.edno3.requestFocus()
                }
                else {
                    val user = registermodel(username, password)
                    prefs?.saveregister(listOf(user))
                    startActivity(Intent(this, LoginActivity::class.java))
                }
            }
        }
    }

    private fun isEmailCorrect(edtemail: AppCompatEditText): Boolean {
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        if (!edtemail.text.toString().trim { it <= ' ' }.matches(emailPattern.toRegex())) {
            edtemail.requestFocus()
            return true
        }
        return false
    }
}