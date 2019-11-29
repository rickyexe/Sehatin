package com.ricky.sehatin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class RestaurantCustomAdapter(val thiscontext: Context,
                              val resto: ArrayList<Restaurant>)
    : ArrayAdapter<Restaurant>(thiscontext,R.layout.listrestaurant_layout, resto ) {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = thiscontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE)
                as LayoutInflater

        val v = inflater.inflate(R.layout.listrestaurant_layout,parent,false)
        val nama = v.findViewById<TextView>(R.id.txtNama)
        val alamat = v.findViewById<TextView>(R.id.txtAlamat)

        nama.text = resto[position].name.toString()
        alamat.text = resto[position].alamat.toString()
        return v

    }

}





