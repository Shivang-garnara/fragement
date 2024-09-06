package com.qtonz.fragement.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.qtonz.fragement.R

class SliderAdapter(private val images: List<Int>, private val titles: List<String>) :
    RecyclerView.Adapter<SliderAdapter.SliderViewHolder>() {

    inner class SliderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val sliderImage: ImageView = view.findViewById(R.id.sliderImage)
        val sliderText: TextView = view.findViewById(R.id.sliderText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.slider_item, parent, false)
        return SliderViewHolder(view)
    }

    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {
        holder.sliderImage.setImageResource(images[position])
        holder.sliderText.text = titles[position]
    }

    override fun getItemCount(): Int {
        return images.size
    }
}
