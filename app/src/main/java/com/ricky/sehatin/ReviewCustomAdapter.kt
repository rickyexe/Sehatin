package com.ricky.sehatin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class ReviewCustomAdapter (val thiscontext: Context,
                           val rev: ArrayList<Review>)
    : ArrayAdapter<Review>(thiscontext,R.layout.review_layout, rev ) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = thiscontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE)
                as LayoutInflater

        val v = inflater.inflate(R.layout.review_layout, parent, false)
        val user = v.findViewById<TextView>(R.id.txtUsername)
        val date = v.findViewById<TextView>(R.id.txttanggal)
        val komen = v.findViewById<TextView>(R.id.txtreview)

        user.text = rev[position].username.toString()
        date.text = rev[position].date.toString()
        komen.text = rev[position].komen.toString()


        return v
    }
}