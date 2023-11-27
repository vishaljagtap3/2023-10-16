package com.bitcodetech.recyclerview1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.setPadding
import androidx.recyclerview.widget.RecyclerView

class MessagesAdapter(
    private val messages: ArrayList<Message>
) : RecyclerView.Adapter<MessagesAdapter.MessageViewHolder>() {

    class MessageViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val imgSender : ImageView
        val txtSender : TextView
        val txtBody : TextView
        val txtDateTime : TextView

        init {
            imgSender = view.findViewById(R.id.imgSender)
            txtSender = view.findViewById(R.id.txtSender)
            txtBody = view.findViewById(R.id.txtBody)
            txtDateTime = view.findViewById(R.id.txtDateTime)
        }
    }

    override fun getItemCount() = messages.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.message_view, null)

        return MessageViewHolder(view)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        holder.imgSender.setImageResource(messages[position].senderImageId)
        holder.txtSender.text = messages[position].sender
        holder.txtBody.text = messages[position].body
        holder.txtDateTime.text = messages[position].dateTime
    }


}