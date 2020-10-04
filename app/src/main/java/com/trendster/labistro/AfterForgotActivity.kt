package com.trendster.labistro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class AfterForgotActivity : AppCompatActivity() {

    lateinit var txtDisplayMobileNumber : TextView
    lateinit var txtDisplayEmailAddress : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_after_forgot)

        txtDisplayMobileNumber = findViewById(R.id.txtDisplayMobileNumber)
        txtDisplayEmailAddress = findViewById(R.id.txtDisplayEmailAddress)

        txtDisplayMobileNumber.text = intent.getStringExtra("RecMobileNumber")
        txtDisplayEmailAddress.text = intent.getStringExtra("RecEmailAddress")
    }
}