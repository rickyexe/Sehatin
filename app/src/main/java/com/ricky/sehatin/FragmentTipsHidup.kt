package com.ricky.sehatin


import android.content.Intent
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
import kotlinx.android.synthetic.main.fragment_fragment_restaurant.*
import kotlinx.android.synthetic.main.fragment_fragment_tips_hidup.*
import org.json.JSONException
import org.json.JSONObject

/**
 * A simple [Fragment] subclass.
 */
class FragmentTipsHidup : Fragment() {

    var tipshidupsehat = ArrayList<TipsHidupSehat>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var something =  inflater.inflate(R.layout.fragment_fragment_tips_hidup, container, false)

        val q = Volley.newRequestQueue(context)
        val url = "http://riset.group/penir/penir_d8/viewtipshidupsehat.php"
        var stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String>
            { response ->
                try {
                    val obj = JSONObject(response)
                    val arr = obj.getJSONArray("tipshidupsehat")
                    tipshidupsehat = ArrayList<TipsHidupSehat>()
                    for (i in 0 until arr.length()) {
                        val tipshidup = arr.getJSONObject(i)
                        tipshidupsehat.add(
                            TipsHidupSehat(
                                tipshidup.getInt("id"),
                                tipshidup.getString("title"),
                                tipshidup.getString("sumber")
                            )
                        )
                    }

                    val arrayAdapter = TipsHidupSehatCustomAdapter(context!!, tipshidupsehat )
                    listtipshidup.adapter = arrayAdapter

//                    listresto.setOnItemClickListener { adapterView, view, i, l ->
//
//                        var intent = Intent(context!! , DetailRestaurantActivity::class.java)
//                        intent.putExtra(DetailRestaurantActivity.id , restaurants[i].id)
//
//                        startActivity(intent)
//
//
//
//
//
//
//
//
//                    }



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
