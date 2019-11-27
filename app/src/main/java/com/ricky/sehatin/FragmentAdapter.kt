package com.ricky.sehatin

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class FragmentAdapter(fm: FragmentManager):
    FragmentPagerAdapter(fm) {

    val fragmentList:ArrayList<Fragment> =
        ArrayList<Fragment>()
    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

    public fun addFragment(f:Fragment) {
        fragmentList.add(f)
    }

}

