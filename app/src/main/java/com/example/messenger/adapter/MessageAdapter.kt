package com.example.messenger.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.messenger.R
import com.example.messenger.model.Message

class MessageAdapter(
    private val messageList: List<Message>,
    private val onItemClick: (Message) -> Unit
) : RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {

    inner class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameText: TextView = itemView.findViewById(R.id.nameTextView)
        val previewText: TextView = itemView.findViewById(R.id.previewTextView)
        val timeText: TextView = itemView.findViewById(R.id.timeTextView)
        val avatarImage: ImageView = itemView.findViewById(R.id.avatarImageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.message_item, parent, false)
        return MessageViewHolder(view)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val message = messageList[position]
        holder.nameText.text = message.sender
        holder.previewText.text = message.content
        holder.timeText.text = message.time
        holder.itemView.setOnClickListener { onItemClick(message) }
    }

    override fun getItemCount(): Int = messageList.size
}