package com.qtonz.fragement.activitys

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.qtonz.fragement.R
import com.qtonz.fragement.databinding.ActivitySimpleFragmentBinding
import com.qtonz.fragement.fragments.SimpleFragment

class SimpleFragmentActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivitySimpleFragmentBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setFragment()
    }
    private fun setFragment() {
        val manger = supportFragmentManager
        val tt= manger.beginTransaction()
        tt.replace(R.id.fram,SimpleFragment()).commit()
    }
}