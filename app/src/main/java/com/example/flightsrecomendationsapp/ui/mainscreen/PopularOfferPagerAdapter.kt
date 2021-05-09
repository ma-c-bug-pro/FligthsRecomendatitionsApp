package com.example.flightsrecomendationsapp.ui.mainscreen

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class PopularOfferPagerAdapter(private val fm: FragmentManager): FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    /**
     * Contains pairs of {pageTitle, fragment}
     * Could make an object with properties title and fragment
     */
    private var fragmentList: ArrayList<Pair<String, Fragment>> = ArrayList()
    override fun getCount(): Int {
        return fragmentList.size
    }

    override fun getItem(position: Int): Fragment {
        return fragmentList[position].second
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return fragmentList[position].first
    }

    public fun addFragment(title: String, fragment: Fragment) {
        fragmentList.add(Pair(title, fragment))
    }
}