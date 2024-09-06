package com.qtonz.fragement.dynamic

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.qtonz.fragement.R
import com.qtonz.fragement.databinding.ActivityChatDetailsBinding
import com.qtonz.fragement.dynamic.adapter.ChatAdapter
import com.qtonz.fragement.dynamic.data.ChatMessage

class EmployeDetailsActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var chatAdapter: ChatAdapter
    private lateinit var editText: EditText
    private val IMAGE_PICK_CODE = 1001
    private var selectedImageUri: Uri? = null
    private val chatList = mutableListOf<ChatMessage>()

    val binding: ActivityChatDetailsBinding by lazy {
        ActivityChatDetailsBinding.inflate(layoutInflater)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        chatAdapter = ChatAdapter(chatList)
        binding.chat.layoutManager = LinearLayoutManager(this)
        binding.chat.adapter = chatAdapter

        editText = findViewById(R.id.editText)

        editText.setOnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                val drawableEnd = editText.compoundDrawables[2]
                if (drawableEnd != null && event.rawX >= (editText.right - drawableEnd.bounds.width())) {
                    openImagePicker()
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
                if (selectedImageUri != null) {
                    chatList.add(ChatMessage("", true, selectedImageUri))
                    selectedImageUri = null // Reset after sending the image
                } else {
                    val userMessage = binding.editText.text.toString().trim()
                    if (userMessage.isNotEmpty()) {
                        chatList.add(ChatMessage(userMessage, true))

                        val botResponse = when (userMessage.lowercase()) {
                            "hii" -> "hii am a bot"
                            "i am shivang" -> "how are you"
                            else -> "Sample system reply"
                        }
                        chatList.add(ChatMessage(botResponse, false))

                        chatAdapter.notifyDataSetChanged()
                        binding.chat.scrollToPosition(chatList.size - 1)
                        binding.editText.text.clear()
                    }
                }

                chatAdapter.notifyDataSetChanged()
            }
        }
    }

    private fun openImagePicker() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_PICK_CODE)
    }

    @Deprecated("This method is deprecated. Use Activity Result API.")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == IMAGE_PICK_CODE && resultCode == Activity.RESULT_OK && data != null) {
            selectedImageUri = data.data
        }
    }
}
