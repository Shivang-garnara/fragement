package com.qtonz.fragement.activitys

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.qtonz.fragement.R
import com.qtonz.fragement.adapter.SliderAdapter
import com.qtonz.fragement.databinding.ActivitySimpleSliderBinding

class SimpleSliderActivity : AppCompatActivity() {
    private val binding: ActivitySimpleSliderBinding by lazy {
        ActivitySimpleSliderBinding.inflate(layoutInflater)
    }
    private lateinit var handler: Handler
    private lateinit var sliderAdapter: SliderAdapter
    private var currentPage = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//        viewPager = findViewById(R.id.viewPager)
        val images = listOf(
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background
        )
        val titles = listOf("Title 1", "Title 2", "Title 3")

        sliderAdapter = SliderAdapter(images, titles)
//        viewPager.adapter = sliderAdapter

        binding.viewPager.adapter = sliderAdapter
        handler = Handler(Looper.getMainLooper())
        startAutoSlide()

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                currentPage = position
                resetAutoSlide()
            }
        })
    }

    private fun startAutoSlide() {
        handler.postDelayed(slideRunnable, 2000) // 2 seconds
    }

    private fun resetAutoSlide() {
        handler.removeCallbacks(slideRunnable)
        startAutoSlide()
    }

    private val slideRunnable = object : Runnable {
        override fun run() {
            if (currentPage == sliderAdapter.itemCount - 1) {
                currentPage = 0
            } else {
                currentPage++
            }
            binding.viewPager.setCurrentItem(currentPage, true)
            handler.postDelayed(this, 2000)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(slideRunnable)
    }
}


//import android.os.Bundle
//import androidx.appcompat.app.AppCompatActivity
//import androidx.viewpager2.widget.ViewPager2
//
//class SimpleSliderActivity : AppCompatActivity() {
//    private val binding: ActivitySimpleSliderBinding by lazy {
//        ActivitySimpleSliderBinding.inflate(layoutInflater)
//    }
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(binding.root)
//
//        viewPager = findViewById(R.id.viewPager)
//        val images = listOf(
//            R.drawable.ic_launcher_background,
//            R.drawable.ic_launcher_background,
//            R.drawable.ic_launcher_background
//        )
//        val titles = listOf("Title 1", "Title 2", "Title 3")
//
//        val adapter = SliderAdapter(images, titles)
//        viewPager.adapter = adapter
//    }
//}
