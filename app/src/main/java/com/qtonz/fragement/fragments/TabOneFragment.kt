package com.qtonz.fragement.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.qtonz.fragement.databinding.FragmentGeeksBinding


class TabOneFragment : Fragment() {
    private lateinit var binding:FragmentGeeksBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) : View {
        binding = FragmentGeeksBinding.inflate(inflater, container, false)
        binding.btnFraOne.setOnClickListener {

        }
        return binding.root
    }

    companion object {
    }
}