package com.ricky.sehatin


import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_restaurant.*
import kotlinx.android.synthetic.main.fragment_fragment_profile.*
import kotlinx.android.synthetic.main.fragment_fragment_profile.view.*
import org.json.JSONException
import org.json.JSONObject


/**
 * A simple [Fragment] subclass.
 */
class FragmentProfile : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val vieww = inflater.inflate(R.layout.fragment_fragment_profile, container, false)



        val pref: SharedPreferences = this.activity!!.getSharedPreferences("login", Context.MODE_PRIVATE)

        val iduser = pref.getInt("id", 0)

        vieww.btnLogout.setOnClickListener {
            val preference = pref.edit()
            preference.putBoolean("login",false)
            preference.apply()

            val homeIntent = Intent(context, LoginActivity::class.java)
            homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(homeIntent)
        }



        val q = Volley.newRequestQueue(context)
        val url = "http://riset.group/penir/penir_d8/profile.php"
        val stringRequest = object :
            StringRequest(
                Request.Method.DEPRECATED_GET_OR_POST, url, Response.Listener<String>
                { response ->
                    try {
                        val obj = JSONObject(response)
                        val arr = obj.getJSONArray("profile")

                        for (i in 0 until arr.length()) {
                            val profile = arr.getJSONObject(i)

                            txtJumlahReview.text = profile.getInt("komentar").toString()
                            txtProfile.text = profile.getString("username")


                        }







                    } catch (e: JSONException) {
                        Toast.makeText(
                            context, e.message.toString(),
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                },
                Response.ErrorListener {}) {
            override fun getParams(): Map<String, String> {
                val params = HashMap<String, String>()
                params.put("iduser", iduser.toString())
                return params
            }
        }

        q.add(stringRequest)



        return vieww




        // Inflate the layout for this fragment

    }


}
