package com.trendster.labistro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class RegisterActivity : AppCompatActivity() {

    lateinit var etName : EditText
    lateinit var etEmail : EditText
    lateinit var etMobileNumber : EditText
    lateinit var etDelivery : EditText
    lateinit var etPassword : EditText
    lateinit var etConfirmPassword : EditText
    lateinit var btnRegister : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        etName = findViewById(R.id.etName)
        etEmail = findViewById(R.id.etEmail)
        etMobileNumber = findViewById(R.id.etMobileNumber)
        etDelivery = findViewById(R.id.etDelivery)
        etPassword = findViewById(R.id.etPassword)
        etConfirmPassword = findViewById(R.id.etConfirmPassword)
        btnRegister = findViewById(R.id.btnRegister)

        btnRegister.setOnClickListener {

            intent = Intent(this@RegisterActivity , AfterRegisterActivity::class.java)

            val name = etName.text.toString()
            val email = etEmail.text.toString()
            val mobileNumber = etMobileNumber.text.toString()
            val delivery = etDelivery.text.toString()
            val password = etPassword.text.toString()
            val confirmPass = etConfirmPassword.text.toString()


            if(name != null){
                if(email != null){
                    if(mobileNumber != null){
                        if(password ==confirmPass){

                            intent.putExtra("Name" , name)
                            intent.putExtra("Email" , email)
                            intent.putExtra("MobileNumber" , mobileNumber)
                            intent.putExtra("Delivery" , delivery)
                            intent.putExtra("Password" , password)

                            startActivity(intent)

                        }else{
                            Toast.makeText(this@RegisterActivity , "Password did't match !!" , Toast.LENGTH_SHORT).show()
                        }
                    }else{
                        Toast.makeText(this@RegisterActivity , "MobileNumber can't be Empty!" , Toast.LENGTH_SHORT).show()
                    }
                }else{
                    Toast.makeText(this@RegisterActivity , "Email can't be Empty!" , Toast.LENGTH_SHORT).show()
                }


            }else{
                Toast.makeText(this@RegisterActivity , "Name can't be Empty!" , Toast.LENGTH_SHORT).show()
            }





        }

    }
}
