package com.qtonz.fragement.radiobuttonadapter.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.qtonz.fragement.databinding.RadioButtonActivityBinding
import com.qtonz.fragement.radiobuttonadapter.data.RadioButtonModel

class RadioButtonAdapter(private val mList: List<RadioButtonModel>) :
    RecyclerView.Adapter<RadioButtonAdapter.ViewHolder>() {
    private var selectedPosition = 0

    private var currentSelectedPos = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            RadioButtonActivityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = mList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mList[position], position)
    }

    inner class ViewHolder(val binding: RadioButtonActivityBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("NotifyDataSetChanged")
        fun bind(mList: RadioButtonModel, position: Int) {
            binding.imgAppLock.setImageResource(mList.image)
            binding.tvIconName.text = mList.text
            binding.radioButton.isChecked = position == selectedPosition

            currentSelectedPos = if(position == selectedPosition) {
                selectedPosition
            } else {
                0
            }

            binding.radioButton.setOnClickListener {
                selectedPosition = position
                notifyItemChanged(selectedPosition)
                notifyItemChanged(currentSelectedPos)
            }
//            binding.radioButton.isChecked = position == selectedPosition
//            binding.radioButton.setOnClickListener {
//                selectedPosition = position
////                notifyItemChanged(position)
////                notifyItemChanged(selectedPosition)
//            }
        }
    }
}