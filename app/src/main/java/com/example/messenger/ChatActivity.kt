package com.example.messenger

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.messenger.adapter.ChatAdapter
import com.example.messenger.model.ChatMessage
import com.google.android.material.appbar.MaterialToolbar

class ChatActivity : AppCompatActivity() {

    private lateinit var adapter: ChatAdapter
    private lateinit var messageList: MutableList<ChatMessage>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        // Setup toolbar
        val toolbar = findViewById<MaterialToolbar>(R.id.chatToolbar)
        val title = intent.getStringExtra("chatTitle")
        toolbar.title = title ?: "Chat"
        toolbar.setNavigationOnClickListener { finish() }

        // Find views
        val recyclerView = findViewById<RecyclerView>(R.id.chatRecyclerView)
        val messageInput = findViewById<EditText>(R.id.messageInput)
        val sendButton = findViewById<ImageButton>(R.id.sendButton)

        // Dummy static chat messages
        messageList = mutableListOf(
            ChatMessage("Hey, how are you?", false),
            ChatMessage("I'm good, and you?", true),
            ChatMessage("Doing great, thanks!", false)
        )

        // Setup adapter and RecyclerView
        adapter = ChatAdapter(messageList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        // Send button logic
        sendButton.setOnClickListener {
            val text = messageInput.text.toString().trim()
            if (text.isNotEmpty()) {
                messageList.add(ChatMessage(text, true))
                adapter.notifyItemInserted(messageList.size - 1)
                recyclerView.scrollToPosition(messageList.size - 1)
                messageInput.text.clear()
            }
        }
    }
}
