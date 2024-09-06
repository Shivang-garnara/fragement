package com.qtonz.fragement.dynamic.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.qtonz.fragement.dynamic.fragment.CallsFragment
import com.qtonz.fragement.dynamic.fragment.ChatFragment
import com.qtonz.fragement.dynamic.fragment.StatusFragment

class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> ChatFragment()
            1 -> StatusFragment()
            else -> CallsFragment()
        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Chat"
            1 -> "Status"
            else -> "Calls"
        }
    }
}
