package com.example.messenger

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.messenger.adapter.MessageAdapter
import com.example.messenger.model.Message
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MessageAdapter
    private lateinit var fab: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)

        recyclerView = findViewById(R.id.messageRecyclerView)
        fab = findViewById(R.id.fabStartChat)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val messages = listOf(
            Message("Alice", "Hey, what's up?", "10:30 AM"),
            Message("Bob", "Meeting at 2PM", "9:15 AM"),
            Message("Charlie", "Got your email", "Yesterday"),
            Message("Diana", "See you soon!", "Tue")
        )

        adapter = MessageAdapter(messages)
        recyclerView.adapter = adapter

        fab.setOnClickListener {
            Toast.makeText(this, "Start Chat clicked!", Toast.LENGTH_SHORT).show()
        }
    }
}
