package com.ricky.sehatin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class TipsMakanSehatCustomAdapter(val thiscontext: Context,
                                  val tipsmakan: ArrayList<TipsMakanSehat>)
    : ArrayAdapter<TipsMakanSehat>(thiscontext,R.layout.listtipsmakansehat_layout, tipsmakan ) {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = thiscontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE)
                as LayoutInflater

        val v = inflater.inflate(R.layout.listtipsmakansehat_layout,parent,false)
        val nama = v.findViewById<TextView>(R.id.txtNama)
        val sumber = v.findViewById<TextView>(R.id.txtAlamat)

        nama.text = tipsmakan[position].title.toString()
        sumber.text = tipsmakan[position].sumber.toString()
        return v

    }

}