package com.qtonz.fragement.dynamic

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.qtonz.fragement.R
import com.qtonz.fragement.databinding.ActivityChatDetailsBinding
import com.qtonz.fragement.dynamic.adapter.ChatAdapter
import com.qtonz.fragement.dynamic.data.ChatMessage
import java.text.SimpleDateFormat
import java.util.Date

class EmployeDetailsActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var chatAdapter: ChatAdapter
    private var selectedImageUris: List<Uri> = emptyList()
    private val chatList = mutableListOf<ChatMessage>()
    private val currentTime =
        SimpleDateFormat("hh:mm a", java.util.Locale.getDefault()).format(Date())

    private val binding: ActivityChatDetailsBinding by lazy {
        ActivityChatDetailsBinding.inflate(layoutInflater)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        chatAdapter = ChatAdapter(chatList)
        binding.chat.layoutManager = LinearLayoutManager(this)
        binding.chat.adapter = chatAdapter

        binding.editText.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                val drawableEnd = binding.editText.compoundDrawables[2]
                if (drawableEnd != null && event.rawX >= (binding.editText.right - drawableEnd.bounds.width())) {
                    pickMultipleMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
                    return@setOnTouchListener true
                }
            }
            false
        }

        binding.floatingActionButton.setOnClickListener(this)

        val name = intent.getStringExtra("name")
        val imgResId = intent.getIntExtra("img", 0)
        binding.img.setImageResource(imgResId)
        binding.tvText.text = name

        addListener()
    }

    private fun addListener() {
        binding.imgBack.setOnClickListener(this)
        binding.floatingActionButton.setOnClickListener(this)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.imgBack -> {
                startActivity(Intent(this@EmployeDetailsActivity, WhatsappMainActivity::class.java))
            }

            R.id.floatingActionButton -> {
                if (selectedImageUris.isNotEmpty()) {
                    selectedImageUris.forEach { uri ->
                        chatList.add(ChatMessage("", true, uri, currentTime))
                        chatList.add(
                            ChatMessage(
                                "${selectedImageUris.indexOf(uri)}", false, null, currentTime
                            )
                        )
                    }
                    selectedImageUris = emptyList()
                } else {
                    val userMessage = binding.editText.text.toString().trim()
                    if (userMessage.isNotEmpty()) {
                        chatList.add(ChatMessage(userMessage, true, null, currentTime))

                        val botResponse = when (userMessage.lowercase()) {
                            "hii" -> "hii am a bot"
                            "i am shivang" -> "how are you"
                            else -> "Sample system reply"
                        }
                        chatList.add(ChatMessage(botResponse, false, null, currentTime))

                        chatAdapter.notifyDataSetChanged()
                        binding.chat.scrollToPosition(chatList.size - 1)
                        binding.editText.text.clear()
                    }
                }
                chatAdapter.notifyDataSetChanged()
            }
        }
    }

    private val pickMultipleMedia =
        registerForActivityResult(ActivityResultContracts.PickMultipleVisualMedia(5)) { uris ->
            if (uris.isNotEmpty()) {
                Log.d("PhotoPicker", "Number of items selected: ${uris.size}")
                selectedImageUris = uris
            } else {
                Log.d("PhotoPicker", "No media selected")
            }
        }
}


//    private fun openImagePicker() {
//        val intent = Intent(Intent.ACTION_PICK)
//        intent.type = "image/*"
//        startActivityForResult(intent, IMAGE_PICK_CODE)
//    }
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == IMAGE_PICK_CODE && resultCode == Activity.RESULT_OK && data != null) {
//            selectedImageUri = data.data
//        }
//    }