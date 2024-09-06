package com.qtonz.fragement.dynamic

import com.qtonz.fragement.R


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.qtonz.fragement.dynamic.adapter.ViewPagerAdapter

class WhatsappMainActivity : AppCompatActivity() {

    private lateinit var tlOption: TabLayout
    private lateinit var vpContent: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_layout)
        bindView()

        val adapter = ViewPagerAdapter(supportFragmentManager)
        vpContent.adapter = adapter
        tlOption.setupWithViewPager(vpContent)
    }

    private fun bindView() {
        tlOption = findViewById(R.id.tlOption)
        vpContent = findViewById(R.id.vpContent)
    }

    fun setCurrentItem(index: Int) {
        vpContent.currentItem = index
    }
}
