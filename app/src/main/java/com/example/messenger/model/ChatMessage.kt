package com.example.messenger.model

data class ChatMessage(
    val message: String,
    val isSent: Boolean // true if sent by user, false if received
)
