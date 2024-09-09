package com.qtonz.fragement

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.color.utilities.DynamicColor
import com.qtonz.fragement.activitys.ChangeFragmentActivity
import com.qtonz.fragement.activitys.SimpleFragmentActivity
import com.qtonz.fragement.activitys.SimpleSliderActivity
import com.qtonz.fragement.activitys.ViewPagerActivity
import com.qtonz.fragement.databinding.ActivityMainBinding
import com.qtonz.fragement.dynamic.WhatsappMainActivity
import com.qtonz.fragement.radiobuttonadapter.activity.RadioButtonActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        addListener()
    }

    private fun addListener() {
        binding.btnSimpleFragment.setOnClickListener(this)
        binding.btnChangeFragment.setOnClickListener(this)
        binding.btnViewPager.setOnClickListener(this)
        binding.btnSimpleSlider.setOnClickListener(this)
        binding.btnDyamicFragment.setOnClickListener(this)
        binding.btnRadioButtomAdapter.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btnSimpleFragment -> {
                startActivity(
                    Intent(
                        this@MainActivity, SimpleFragmentActivity::class.java
                    )
                )
            }

            R.id.btnChangeFragment -> {
                startActivity(
                    Intent(
                        this@MainActivity, ChangeFragmentActivity::class.java
                    )
                )
            }

            R.id.btnViewPager -> {
                startActivity(
                    Intent(
                        this@MainActivity, ViewPagerActivity::class.java
                    )
                )
            }
            R.id.btnSimpleSlider -> {
                startActivity(
                    Intent(
                        this@MainActivity, SimpleSliderActivity::class.java
                    )
                )
            }
            R.id.btnDyamicFragment ->{
                startActivity(
                    Intent(
                        this@MainActivity, WhatsappMainActivity::class.java
                    )
                )
            }
            R.id.btnRadioButtomAdapter ->{
                startActivity(
                    Intent(
                        this@MainActivity, RadioButtonActivity::class.java
                    )
                )
            }
        }
    }
}