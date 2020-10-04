package com.trendster.labistro

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences
    var titleName :String ?= "Administrator"
    lateinit var btnLogOut : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)

        setContentView(R.layout.activity_home)

        title = titleName
///////////////////////////////////////////////////////////
        btnLogOut = findViewById(R.id.btnLogOut)

        btnLogOut.setOnClickListener {
            clearPreferences()
            Toast.makeText(this@HomeActivity , "Log Out Successful !" , Toast.LENGTH_SHORT).show()
            finish()
        }

    }

    fun clearPreferences(){
        sharedPreferences.edit().clear().apply()

    }
}