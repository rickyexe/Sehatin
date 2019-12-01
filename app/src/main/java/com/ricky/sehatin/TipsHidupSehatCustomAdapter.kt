package com.ricky.sehatin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class TipsHidupSehatCustomAdapter(val thiscontext: Context,
                              val tipshidup: ArrayList<TipsHidupSehat>)
    : ArrayAdapter<TipsHidupSehat>(thiscontext,R.layout.listtipshidupsehat_layout, tipshidup ) {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = thiscontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE)
                as LayoutInflater

        val v = inflater.inflate(R.layout.listtipshidupsehat_layout,parent,false)
        val nama = v.findViewById<TextView>(R.id.txtTitle)
        val sumber = v.findViewById<TextView>(R.id.txtSumber)

        nama.text = tipshidup[position].title.toString()
        sumber.text = tipshidup[position].sumber.toString()
        return v

    }

}