package com.bitcodetech.recyclerview1

import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import android.widget.TextView
import androidx.core.view.setPadding
import androidx.recyclerview.widget.RecyclerView

class MessagesAdapter(
    private val messages: ArrayList<String>
) : RecyclerView.Adapter<MessagesAdapter.MessageViewHolder>() {

    class MessageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var txtMessage: TextView

        init {
            txtMessage = view as TextView
        }
    }

    override fun getItemCount() = messages.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val txtMessage = TextView(parent.context)
        txtMessage.layoutParams =
            ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        txtMessage.textSize = 30f
        txtMessage.setPadding(10)

        return MessageViewHolder(txtMessage)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        holder.txtMessage.text = messages[position]
    }


}