package com.qtonz.fragement.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.qtonz.fragement.R
import com.qtonz.fragement.databinding.FragmentSimpleBinding

class SimpleFragment : Fragment() {

    private lateinit var binding:FragmentSimpleBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSimpleBinding.inflate(inflater, container, false)
        binding.btnTest.setOnClickListener{
            Toast.makeText(context, getString(R.string.this_is_fragment_test), Toast.LENGTH_LONG).show()
        }
        return binding.root
    }

    companion object {
    }
}