package com.ricky.sehatin


import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_fragment_profile.*
import kotlinx.android.synthetic.main.fragment_fragment_profile.view.*


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

        val idd = pref.getInt("id", 0)

        vieww.btnLogout.setOnClickListener {
            val preference = pref.edit()
            preference.putBoolean("login",false)
            preference.apply()

            val homeIntent = Intent(context, LoginActivity::class.java)
            homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(homeIntent)
        }

        return vieww




        // Inflate the layout for this fragment

    }


}
