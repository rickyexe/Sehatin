package com.ricky.sehatin

import android.content.Intent
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
import kotlinx.android.synthetic.main.activity_register.*
import org.json.JSONException
import org.json.JSONObject
import org.json.JSONStringer

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)




        txtMasuk.setOnClickListener {
            val homeIntent = Intent(this, LoginActivity::class.java)
            homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)

            startActivity(homeIntent)
        }

        btnRegister.setOnClickListener {

            val username = txtUsernameRegister.text.toString()
            val password  = txtPasswordRegister.text.toString()


            val q = Volley.newRequestQueue(this)
            val url = "http://riset.group/penir/penir_d8/register.php"
            val stringRequest = object: StringRequest(
                Request.Method.DEPRECATED_GET_OR_POST, url, Response.Listener<String>
                {
                        response ->
                    try {
                        Toast.makeText(this, response , Toast.LENGTH_SHORT ).show()

                        if(response == "Berhasil Mendaftar")
                        {
                            val homeIntent = Intent(this, LoginActivity::class.java)
                            homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)

                            startActivity(homeIntent)
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
    }
}
