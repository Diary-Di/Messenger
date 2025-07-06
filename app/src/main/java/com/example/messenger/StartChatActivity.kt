package com.example.messenger

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.messenger.adapter.PersonAdapter
import com.example.messenger.model.Person
import com.google.android.material.appbar.MaterialToolbar

class StartChatActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_chat)

        // Setup toolbar
        val toolbar = findViewById<MaterialToolbar>(R.id.startChatToolbar)
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener {
            finish() // Return to HomeActivity
        }

        // RecyclerView setup
        val recyclerView = findViewById<RecyclerView>(R.id.personRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val people = listOf(
            Person("Alice Smith"),
            Person("Bob Johnson"),
            Person("Charlie Doe"),
            Person("Diana Ray")
        )

        val adapter = PersonAdapter(people)
        recyclerView.adapter = adapter
    }
}
