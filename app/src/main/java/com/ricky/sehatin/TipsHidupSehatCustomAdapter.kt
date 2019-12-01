package com.ricky.sehatin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class TipsHidupSehatCustomAdapter(val thiscontext: Context,
                              val tipshidup: ArrayList<TipsHidupSehat>)
    : ArrayAdapter<TipsHidupSehat>(thiscontext,R.layout.listtipshidupsehat_layout, tipshidup ) {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = thiscontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE)
                as LayoutInflater

        val v = inflater.inflate(R.layout.listtipshidupsehat_layout,parent,false)
        val nama = v.findViewById<TextView>(R.id.txtNama)
        val sumber = v.findViewById<TextView>(R.id.txtAlamat)
        val images = v.findViewById<ImageView>(R.id.imgTipsHidup)

        nama.text = tipshidup[position].title.toString()
        sumber.text = tipshidup[position].sumber.toString()
        Picasso.with(context).load(tipshidup[position].logo).resize(100,100).into(images)
        return v

    }

}