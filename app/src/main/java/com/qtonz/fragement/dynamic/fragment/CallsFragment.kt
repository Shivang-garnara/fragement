package com.qtonz.fragement.dynamic.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.widget.Button
import com.qtonz.fragement.R

class CallsFragment : Fragment() {

    private lateinit var btnChat: Button
    private lateinit var btnActivity: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_calls, container, false)

        return view
    }
}
