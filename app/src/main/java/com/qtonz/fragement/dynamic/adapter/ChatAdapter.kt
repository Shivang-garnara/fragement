package com.qtonz.fragement.dynamic.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.qtonz.fragement.databinding.ItemChatBinding
import com.qtonz.fragement.dynamic.data.ChatMessage

class ChatAdapter(private val chatList: MutableList<ChatMessage>) :
    RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {

    inner class ChatViewHolder(val binding: ItemChatBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(chatMessage: ChatMessage) {
                    if (chatMessage.imageUri != null) {
                        binding.img.setImageURI(chatMessage.imageUri)
                        binding.img.visibility = View.VISIBLE
                        binding.tvUserMessage.visibility = View.GONE
                        binding.tvSystemMessage.visibility = View.GONE
                    } else {
                        binding.img.visibility = View.GONE
                        if (!chatMessage.isSentByUser) {
                            binding.tvSystemMessage.text = chatMessage.message
                            binding.tvSystemMessage.visibility = View.VISIBLE
                            binding.tvUserMessage.visibility = View.GONE
                        } else {
                            binding.tvUserMessage.text = chatMessage.message
                            binding.tvUserMessage.visibility = View.VISIBLE
                            binding.tvSystemMessage.visibility = View.GONE
                        }
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val binding = ItemChatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChatViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        holder.bind(chatList[position])
    }

    override fun getItemCount(): Int = chatList.size
}
