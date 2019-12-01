package com.ricky.sehatin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_detail_restaurant.*
import org.json.JSONException
import org.json.JSONObject

class DetailRestaurantActivity : AppCompatActivity() {
    var resto = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_restaurant)

        val intent = this.intent
        val id = intent.getIntExtra(id,0)

        val q = Volley.newRequestQueue(this)
        val url = "http://riset.group/penir/penir_d8/viewdetailrestaurant.php"
        val stringRequest = object: StringRequest(Request.Method.DEPRECATED_GET_OR_POST, url, Response.Listener<String>
        {
                response ->
            try {
                val obj = JSONObject(response)
                val arr = obj.getJSONArray("restoran")


                for (i in 0 until arr.length()) {
                    val restaurant = arr.getJSONObject(i)
                    txtTitle.text = restaurant.getString("nama_restaurant")
                    txtSumber.text = restaurant.getString("alamat_restaurant")

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
                params.put("id", id.toString())
                return params
            }
        }

        q.add(stringRequest)

//        val url2 = "http://riset.group/penir/penir_d8/viewrestaurantdetail.php"
//        var stringRequest2 = StringRequest(Request.Method.GET, url,
//            Response.Listener<String>
//            { response ->
//                try {
//                    val obj = JSONObject(response)
//                    val arr = obj.getJSONArray("restoran")
//
//                    for (i in 0 until arr.length()) {
//                        val restaurant = arr.getJSONObject(i)
//
//                       txtNama.text = restaurant.toString()
//
//
//
//
//
//
//                    }
//
//
////                    txtNama.text = resto[0]
////                    txtAlamat.text = resto[1]
//
//                } catch (e: JSONException) {
//                    Toast.makeText(
//                        this, e.message.toString(),
//                        Toast.LENGTH_SHORT
//                    ).show()
//                }
//
//            },
//            Response.ErrorListener
//            { response ->
//                Toast.makeText(
//                    this, response.toString(),
//                    Toast.LENGTH_SHORT
//                ).show()
//
//            })
//        q.add(stringRequest2)










    }


    companion object{
        const val id = "ID"
    }
}
