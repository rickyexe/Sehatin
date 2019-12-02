package com.ricky.sehatin

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_tambah_komentar.*
import org.json.JSONException

class TambahKomentarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_komentar)


        val intent = this.intent
        val idresto = intent.getIntExtra(idrestoran,0)




        btnTambahKomentar.setOnClickListener {

            val komentar = txtKomentar.text.toString()


            val q = Volley.newRequestQueue(this)
            val url = "http://riset.group/penir/penir_d8/tambahkomentar.php"
            val stringRequest = object: StringRequest(
                Request.Method.DEPRECATED_GET_OR_POST, url, Response.Listener<String>
                {
                        response ->
                    try {

                        if(response == "Berhasil")
                        {
                            finish()
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

                    val pref: SharedPreferences = getSharedPreferences("login", Context.MODE_PRIVATE)

                    val iduser = pref.getInt("id", 0)

                    val params = HashMap<String,String>()
                    params.put("iduser", iduser.toString())
                    params.put("idrestoran", idresto.toString()  )
                    params.put("komentar", komentar)
                    return params
                }
            }

            q.add(stringRequest)
        }
    }

    companion object
    {
        const val idrestoran = "IDRESTORAN"
    }
}
