package com.qtonz.fragement.activitys

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.qtonz.fragement.R
import com.qtonz.fragement.adapter.ViewPagerAdapter
import com.qtonz.fragement.databinding.ActivityViewPagerBinding
import com.qtonz.fragement.fragments.TabThreeFragment
import com.qtonz.fragement.fragments.TabOneFragment
import com.qtonz.fragement.fragments.TabTwoFragment

class ViewPagerActivity : AppCompatActivity() {
    private lateinit var pager: ViewPager
    private lateinit var tab: TabLayout
    private val binding: ActivityViewPagerBinding by lazy {
        ActivityViewPagerBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        pager = findViewById(R.id.viewPager)
        tab = findViewById(R.id.tabs)
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(TabOneFragment(), "Tab One")
        adapter.addFragment(TabThreeFragment(), "Tab Two")
        adapter.addFragment(TabTwoFragment(), "Tab Three")
        pager.adapter = adapter
        tab.setupWithViewPager(pager)
    }
}