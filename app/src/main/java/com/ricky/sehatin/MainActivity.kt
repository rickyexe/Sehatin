package com.ricky.sehatin

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {






    override fun onCreate(savedInstanceState: Bundle?) {
        var restaurants = ArrayList<Restaurant>()
        super.onCreate(savedInstanceState)



        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        scrollview.isFillViewport = true




        val fa = FragmentAdapter(supportFragmentManager)
        fa.addFragment(FragmentRestaurant())
        fa.addFragment(FragmentTipsHidup())
        fa.addFragment(FragmentTipsMakan())
        fa.addFragment(FragmentProfile())
        viewpager.adapter = fa
        tabs.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
            override fun onTabReselected(p0: TabLayout.Tab?) {
            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    viewpager.currentItem = tab.position
                }
            }
        })
        viewpager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(p0: Int) {
            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
            }

            override fun onPageSelected(position: Int) {
                val tab:TabLayout.Tab?=tabs.getTabAt(position)
                tab?.select()
            }

        })



    }
}


