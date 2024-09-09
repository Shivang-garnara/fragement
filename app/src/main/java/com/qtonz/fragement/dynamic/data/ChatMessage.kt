package com.qtonz.fragement.dynamic.data

import android.net.Uri

data class ChatMessage(
    val message: String,
    val isSentByUser: Boolean,
    val imageUri: Uri? = null,
    val timestamp: String
)
