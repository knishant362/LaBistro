package com.trendster.labistro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class ForgotActivity : AppCompatActivity() {

    lateinit var etMobileNumber : EditText
    lateinit var etEmailAddress : EditText
    lateinit var btnNext : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot)

        etMobileNumber = findViewById(R.id.etMobileNumber)
        etEmailAddress = findViewById(R.id.etEmailAddress)
        btnNext = findViewById(R.id.btnNext)

        btnNext.setOnClickListener {

            intent = Intent(this@ForgotActivity , AfterForgotActivity::class.java)

            var SendMobileNumber = etMobileNumber.text.toString()
            var SendEmailAddress = etEmailAddress.text.toString()

            intent.putExtra("RecMobileNumber" , SendMobileNumber)
            intent.putExtra("RecEmailAddress", SendEmailAddress)

            startActivity(intent)
        }


    }
}

