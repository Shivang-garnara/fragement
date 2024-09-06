package com.qtonz.fragement.activitys

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.qtonz.fragement.R
import com.qtonz.fragement.databinding.ActivityChangeFragmentBinding
import com.qtonz.fragement.fragments.ChangeFragmentOne
import com.qtonz.fragement.fragments.ChangeFragmentTwo

class ChangeFragmentActivity : AppCompatActivity(), View.OnClickListener {
    private val binding by lazy {
        ActivityChangeFragmentBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        loadFragment()
        addListener()
    }

    private fun loadFragment() {
        val manger = supportFragmentManager
        val tt = manger.beginTransaction()
        tt.replace(R.id.framChange, ChangeFragmentOne())
//        tt.addToBackStack(null)
        tt.commit()

    }

    private fun addListener() {
        binding.btnFirst.setOnClickListener(this)
        binding.btnSecond.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btnFirst -> {
                val manger = supportFragmentManager
                val tt = manger.beginTransaction()
                tt.replace(R.id.framChange, ChangeFragmentOne())
//                tt.addToBackStack(null)
                tt.commit()
            }

            R.id.btnSecond -> {
                val manger = supportFragmentManager
                val tt = manger.beginTransaction()
                tt.replace(R.id.framChange, ChangeFragmentTwo()).commit()
//                tt.addToBackStack(null)
            }
        }
    }
}