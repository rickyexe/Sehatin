package com.ricky.sehatin

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_restaurant.*
import kotlinx.android.synthetic.main.activity_login.*
import org.json.JSONException
import org.json.JSONObject

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

                val username = txtUsername.text.toString()
                val password = txtPassword.text.toString()

                val q = Volley.newRequestQueue(this)
                val url = "http://riset.group/penir/penir_d8/login.php"
                val stringRequest = object: StringRequest(
                    Request.Method.DEPRECATED_GET_OR_POST, url, Response.Listener<String>
                    {
                            response ->
                        try {





                            val respon = response.substring(0,8)
                            val iduser = response.substring(8)



                            if ( respon=="berhasil")
                            {

                            val editor = sharedPref.edit()
                            editor.putBoolean(PREF_NAME, true)
                            editor.putInt("id", iduser.toInt() )
                            editor.apply()

                            val homeIntent = Intent(this, MainActivity::class.java)

                            startActivity(homeIntent)
                            finish()
                        }
                        else
                        {
                            Toast.makeText(this, response, Toast.LENGTH_LONG).show()
                        }



                        } catch (e: JSONException) {
                            Toast.makeText(
                                this, e.message.toString(),
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                    },
                    Response.ErrorListener {})
                {
                    override fun getParams() : Map<String, String> {
                        val params = HashMap<String,String>()
                        params.put("username", username)
                        params.put("password", password)
                        return params
                    }
                }

                q.add(stringRequest)









            }

            txtDaftar.setOnClickListener {
                val homeIntent = Intent(this, RegisterActivity::class.java)

                startActivity(homeIntent)
            }







        }


    }
}

