package com.example.socityapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.socityapp.databinding.ActivityPaymentBinding
import com.razorpay.Checkout
import com.razorpay.PaymentResultListener


import org.json.JSONException
import org.json.JSONObject


class PaymentActivity : AppCompatActivity(), PaymentResultListener {

    // on below line we are creating
    // variables for our edit text and button
  lateinit var binding:ActivityPaymentBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityPaymentBinding.inflate(layoutInflater)
        initview()
        setContentView(binding.root)


    }

    private fun initview() {
        // on below line we are initializing
        // our variable with their ids.


        // on below line adding click listener for pay button
        binding.idBtnMakePaymanet.setOnClickListener {

            // on below line getting amount from edit text
            val amt = binding.idEdtAmt.text.toString()

            // rounding off the amount.
            val amount = Math.round(amt.toFloat() * 100).toInt()

            // on below line we are
            // initializing razorpay account
            val checkout = Checkout()

            // on the below line we have to see our id.
            checkout.setKeyID("rzp_test_eIZZLoToIxFGRe")

            // set image
            // checkout.setImage(R.drawable.android)

            // initialize json object
            val obj = JSONObject()
            try {
                // to put name
                obj.put("name", "Society System")

                // put description
                obj.put("description", "Test payment")

                // to set theme color
                obj.put("theme.color", "")

                // put the currency
                obj.put("currency", "INR")

                // put amount
                obj.put("amount", amount)

                // put mobile number
                obj.put("prefill.contact", "9284064503")

                // put email
                obj.put("prefill.email", "chaitanyamunje@gmail.com")

                // open razorpay to checkout activity
                checkout.open(this, obj)
            } catch (e: JSONException) {
                e.printStackTrace()
            }
        }
    }

    override fun onPaymentSuccess(s: String?) {
        // this method is called on payment success.
        Toast.makeText(this, "Payment is successful : " + s, Toast.LENGTH_SHORT).show();
    }

    override fun onPaymentError(p0: Int, s: String?) {
        // on payment failed.
        Toast.makeText(this, "Payment Failed due to error : " + s, Toast.LENGTH_SHORT).show();
    }
}
