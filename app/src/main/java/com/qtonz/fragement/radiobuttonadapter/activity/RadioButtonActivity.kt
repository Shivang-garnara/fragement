package com.qtonz.fragement.radiobuttonadapter.activity

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.qtonz.fragement.R
import com.qtonz.fragement.databinding.ActivityRadioButtonBinding
import com.qtonz.fragement.radiobuttonadapter.adapter.RadioButtonAdapter
import com.qtonz.fragement.radiobuttonadapter.data.RadioButtonModel

class RadioButtonActivity : AppCompatActivity()
{
    val binding: ActivityRadioButtonBinding by lazy {
        ActivityRadioButtonBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val itemsList = listOf(
            RadioButtonModel(image = R.drawable.clip, text = "App Loack"),
            RadioButtonModel(image = R.drawable.clip, text = "App Loack"),
            RadioButtonModel(image = R.drawable.clip, text = "App Loack"),
            RadioButtonModel(image = R.drawable.clip, text = "App Loack"),
            RadioButtonModel(image = R.drawable.clip, text = "App Loack"),
            RadioButtonModel(image = R.drawable.clip, text = "App Loack"),
            RadioButtonModel(image = R.drawable.clip, text = "App Loack"),
            RadioButtonModel(image = R.drawable.clip, text = "App Loack"),
            RadioButtonModel(image = R.drawable.clip, text = "App Loack"),
            RadioButtonModel(image = R.drawable.clip, text = "App Loack"),
            RadioButtonModel(image = R.drawable.clip, text = "App Loack"),
            RadioButtonModel(image = R.drawable.clip, text = "App Loack"),
            RadioButtonModel(image = R.drawable.clip, text = "App Loack"),
            RadioButtonModel(image = R.drawable.clip, text = "App Loack"),
            RadioButtonModel(image = R.drawable.clip, text = "App Loack"),
            RadioButtonModel(image = R.drawable.clip, text = "App Loack"),
            RadioButtonModel(image = R.drawable.clip, text = "App Loack"),
            RadioButtonModel(image = R.drawable.clip, text = "App Loack"),
            RadioButtonModel(image = R.drawable.clip, text = "App Loack"),
            RadioButtonModel(image = R.drawable.clip, text = "App Loack"),
            RadioButtonModel(image = R.drawable.clip, text = "App Loack"),
            RadioButtonModel(image = R.drawable.clip, text = "App Loack"),
            RadioButtonModel(image = R.drawable.clip, text = "App Loack"),
            RadioButtonModel(image = R.drawable.clip, text = "App Loack"),
            RadioButtonModel(image = R.drawable.clip, text = "App Loack"),
            RadioButtonModel(image = R.drawable.clip, text = "App Loack"),
            RadioButtonModel(image = R.drawable.clip, text = "App Loack"),
            RadioButtonModel(image = R.drawable.clip, text = "App Loack"),
            RadioButtonModel(image = R.drawable.clip, text = "App Loack"),
            RadioButtonModel(image = R.drawable.clip, text = "App Loack"),
            RadioButtonModel(image = R.drawable.clip, text = "App Loack"),
            RadioButtonModel(image = R.drawable.clip, text = "App Loack"),
            RadioButtonModel(image = R.drawable.clip, text = "App Loack"),
            RadioButtonModel(image = R.drawable.clip, text = "App Loack"),
            RadioButtonModel(image = R.drawable.clip, text = "App Loack"),
            RadioButtonModel(image = R.drawable.clip, text = "App Loack"),
            RadioButtonModel(image = R.drawable.clip, text = "App Loack"),
            RadioButtonModel(image = R.drawable.clip, text = "App Loack"),
            RadioButtonModel(image = R.drawable.clip, text = "App Loack"),
            RadioButtonModel(image = R.drawable.clip, text = "App Loack"),
            RadioButtonModel(image = R.drawable.clip, text = "App Loack"),
            RadioButtonModel(image = R.drawable.clip, text = "App Loack"),
            RadioButtonModel(image = R.drawable.clip, text = "App Loack"),
            RadioButtonModel(image = R.drawable.clip, text = "App Loack"),
            RadioButtonModel(image = R.drawable.clip, text = "App Loack"),
            RadioButtonModel(image = R.drawable.clip, text = "App Loack"),
            RadioButtonModel(image = R.drawable.clip, text = "App Loack"),
            RadioButtonModel(image = R.drawable.clip, text = "App Loack"),
            RadioButtonModel(image = R.drawable.clip, text = "App Loack"),
            RadioButtonModel(image = R.drawable.clip, text = "App Loack"),
            RadioButtonModel(image = R.drawable.clip, text = "App Loack"),
            RadioButtonModel(image = R.drawable.clip, text = "App Loack"),
            RadioButtonModel(image = R.drawable.clip, text = "App Loack"),
        )
        binding.recRadio.layoutManager = LinearLayoutManager(this)
        binding.recRadio.adapter = RadioButtonAdapter(itemsList)
    }
}