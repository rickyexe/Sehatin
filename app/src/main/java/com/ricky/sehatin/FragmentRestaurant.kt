package com.ricky.sehatin


import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.ListFragment
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.fragment_fragment_restaurant.*
import org.json.JSONException
import org.json.JSONObject



/**
 * A simple [Fragment] subclass.
 */
class FragmentRestaurant : Fragment() {

    var restaurants = ArrayList<Restaurant>()





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var something =  inflater.inflate(R.layout.fragment_fragment_restaurant, container, false)

        val q = Volley.newRequestQueue(context)
        val url = "http://riset.group/penir/penir_d8/viewrestaurantlist.php"
        var stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String>
            { response ->
                try {
                    val obj = JSONObject(response)
                    val arr = obj.getJSONArray("restoran")
                    restaurants = ArrayList<Restaurant>()
                    for (i in 0 until arr.length()) {
                        val resto = arr.getJSONObject(i)
                        restaurants.add(
                            Restaurant(
                                resto.getInt("id"),
                                resto.getString("nama_restaurant"),
                                resto.getString("alamat_restaurant"),
                                resto.getString("logo")
                            )
                        )
                    }

                    val arrayAdapter = RestaurantCustomAdapter(context!!, restaurants )
                    listresto.adapter = arrayAdapter

                    listresto.setOnItemClickListener { adapterView, view, i, l ->

                        var intent = Intent(context!! , DetailRestaurantActivity::class.java)
                        intent.putExtra(DetailRestaurantActivity.id , restaurants[i].id)

                        startActivity(intent)

//                        Toast.makeText(context, restaurants[i].id.toString(), Toast.LENGTH_SHORT).show()








                    }



                } catch (e: JSONException) {
                    Toast.makeText(
                        context, e.message.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }

            },
            Response.ErrorListener
            { response ->
                Toast.makeText(
                    context, response.toString(),
                    Toast.LENGTH_SHORT
                ).show()

            })
        q.add(stringRequest)




        return something








    }






}
