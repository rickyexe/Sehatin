package com.ricky.sehatin

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {


    var MODE_PRIVATE = 0
    val PREF_NAME = "login"



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val sharedPref: SharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

        if (sharedPref.getBoolean(PREF_NAME, false)) {
            val Intent = Intent(this, MainActivity::class.java)
            startActivity(Intent)
            finish()
        } else {

            setContentView(R.layout.activity_login)

            btnMasuk.setOnClickListener {
                val editor = sharedPref.edit()
                editor.putBoolean(PREF_NAME, true)
                editor.putInt("id", 5)
                editor.apply()

                val homeIntent = Intent(this, MainActivity::class.java)

                startActivity(homeIntent)
                finish()




            }

            txtDaftar.setOnClickListener {
                val homeIntent = Intent(this, RegisterActivity::class.java)

                startActivity(homeIntent)
            }







        }


    }
}

