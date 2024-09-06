package com.qtonz.fragement.dynamic.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.qtonz.fragement.databinding.RvChatItemBinding
import com.qtonz.fragement.dynamic.data.ChatMessageDataModel

class ChatMessageAdapter(
    private val arrayList: ArrayList<ChatMessageDataModel>,
    private var onItemClicked: ((chatMessageDataModel: ChatMessageDataModel) -> Unit)
) : RecyclerView.Adapter<ChatMessageAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RvChatItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(arrayList[position])
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    inner class ViewHolder(private val binding: RvChatItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ChatMessageDataModel) = binding.apply {
            binding.imgProfileImg.setImageResource(item.imgProfileImage)
            binding.tvMessengerName.text = item.tvMessengerName
            binding.tvMessage.text = item.tvMessage
            binding.tvMessageTime.text = item.tvMessageTime
            root.setOnClickListener {
                onItemClicked(item)
            }
        }
    }
}
