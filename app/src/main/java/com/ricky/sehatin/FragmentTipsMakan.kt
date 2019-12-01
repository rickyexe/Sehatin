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
import kotlinx.android.synthetic.main.fragment_fragment_tips_makan.*
import org.json.JSONException
import org.json.JSONObject

/**
 * A simple [Fragment] subclass.
 */
class FragmentTipsMakan : Fragment() {


    var tipsmakansehat = ArrayList<TipsMakanSehat>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment



        val q = Volley.newRequestQueue(context)
        val url = "http://riset.group/penir/penir_d8/viewtipsmakansehat.php"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String>
            { response ->
                try {
                    val obj = JSONObject(response)
                    val arr = obj.getJSONArray("tipsmakansehat")
                    tipsmakansehat = ArrayList<TipsMakanSehat>()
                    for (i in 0 until arr.length()) {
                        val tipsmakan = arr.getJSONObject(i)
                        tipsmakansehat.add(
                            TipsMakanSehat(
                                tipsmakan.getInt("id"),
                                tipsmakan.getString("title"),
                                tipsmakan.getString("sumber"),
                                tipsmakan.getString("link")
                            )
                        )
                    }
                    val arrayAdapter = TipsMakanSehatCustomAdapter(context!!, tipsmakansehat )
                    listtipsmakan.adapter = arrayAdapter

                    listtipsmakan.setOnItemClickListener { adapterView, view, i, l ->

                        val intent = Intent(context!! , BeritaActivity::class.java)
                        intent.putExtra(BeritaActivity.link , tipsmakansehat[i].link)
                        startActivity(intent)

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

        return inflater.inflate(R.layout.fragment_fragment_tips_makan, container, false)


    }


}
