package com.trendster.labistro

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class LoginActivity : AppCompatActivity() {

    lateinit var etUserName : EditText
    lateinit var etPassword : EditText
    lateinit var btnLogIn : Button
    lateinit var txtForgot : TextView
    lateinit var txtCreateAccount : TextView

    var mobileNumberList = mutableListOf("0")
    var passwordList = mutableListOf("0")

    lateinit var sharedPrefernces : SharedPreferences



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPrefernces = getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)

        val isLoggedIn = sharedPrefernces.getBoolean("isLoggedIn", false)

        setContentView(R.layout.activity_login)


        etUserName = findViewById(R.id.etUserName)
        etPassword = findViewById(R.id.etPassword)
        btnLogIn = findViewById(R.id.btnLogIn)
        txtForgot = findViewById(R.id.txtForgot)
        txtCreateAccount = findViewById(R.id.txtCreateAccount)

        btnLogIn.setOnClickListener {
            var userMobileNumber = etUserName.text.toString()
            var userPassword = etUserName.text.toString()

            intent = Intent(this@LoginActivity , HomeActivity::class.java)
//            startActivity(intent)


            if(mobileNumberList.contains(userMobileNumber)){
                if (passwordList.contains(userPassword)){

                    savePreferences(userMobileNumber)
                    startActivity(intent)

                }else{
                    Toast.makeText(this@LoginActivity , "Invalid Password !" , Toast.LENGTH_SHORT).show()                }

            }else{
                Toast.makeText(this@LoginActivity,"Invalid Mobile Number", Toast.LENGTH_SHORT).show()
            }


        }

        txtForgot.setOnClickListener{

            intent = Intent(this@LoginActivity , ForgotActivity::class.java )
            startActivity(intent)
        }
        txtCreateAccount.setOnClickListener{

            intent = Intent(this@LoginActivity , RegisterActivity::class.java)
            startActivity(intent)
        }


    }

    fun savePreferences(title: String){
        sharedPrefernces.edit().putBoolean("isLoggedIn", true).apply()
        sharedPrefernces.edit().putString("Title", title).apply()
    }
}
