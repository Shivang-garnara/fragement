package com.qtonz.fragement.dynamic.fragment


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.qtonz.fragement.R
import com.qtonz.fragement.databinding.FragmentChatBinding
import com.qtonz.fragement.dynamic.EmployeDetailsActivity
import com.qtonz.fragement.dynamic.adapter.ChatMessageAdapter
import com.qtonz.fragement.dynamic.data.ChatMessageDataModel

class ChatFragment : Fragment() {
    private var _binding: FragmentChatBinding? = null
    private val binding get() = _binding!!
    private val arrayList = ArrayList<ChatMessageDataModel>()
    private lateinit var chatMessageAdapter: ChatMessageAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChatBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arrayList.apply {
            add(ChatMessageDataModel(R.drawable.clip, "Self (You)", "+91 9909988088", "9:30am"))
            add(ChatMessageDataModel(R.drawable.clip, "Sourav Ganguly", "ok", "8:25pm"))
            add(ChatMessageDataModel(R.drawable.clip, "David Warner", "Hello!", "10:30pm"))
            add(ChatMessageDataModel(R.drawable.clip, "Ricky", "Video", "5:30pm"))
            add(ChatMessageDataModel(R.drawable.clip, "Self (You)", "+91 9909988088", "9:30am"))
            add(ChatMessageDataModel(R.drawable.clip, "Sourav Ganguly", "ok", "8:25pm"))
            add(ChatMessageDataModel(R.drawable.clip, "David Warner", "Hello!", "10:30pm"))
            add(ChatMessageDataModel(R.drawable.clip, "Ricky", "Video", "5:30pm"))
            add(ChatMessageDataModel(R.drawable.clip, "David Warner", "Hello!", "10:30pm"))
            add(ChatMessageDataModel(R.drawable.clip, "Ricky", "Video", "5:30pm"))
        }
        binding.rvChat.layoutManager = LinearLayoutManager(requireContext())
        binding.rvChat.setHasFixedSize(true)
        chatMessageAdapter = ChatMessageAdapter(arrayList) { item ->
            val intent = Intent(context, EmployeDetailsActivity::class.java)
            intent.putExtra("name", item.tvMessengerName)
            intent.putExtra("img", item.imgProfileImage)
            startActivity(intent)
        }
        binding.rvChat.adapter = chatMessageAdapter
    }
}

