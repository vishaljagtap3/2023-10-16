package com.bitcodetech.recyclerview1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.setPadding
import androidx.recyclerview.widget.RecyclerView

class MessagesAdapter(
    private val messages: ArrayList<Message>
) : RecyclerView.Adapter<MessagesAdapter.MessageViewHolder>() {

    interface OnMessageClickListener {
        fun onMessageClick(position : Int, message : Message, view : View)
    }

    var onMessageClickListener : OnMessageClickListener? = null

    inner class MessageViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val imgSender : ImageView
        val txtSender : TextView
        val txtBody : TextView
        val txtDateTime : TextView

        init {
            imgSender = view.findViewById(R.id.imgSender)
            txtSender = view.findViewById(R.id.txtSender)
            txtBody = view.findViewById(R.id.txtBody)
            txtDateTime = view.findViewById(R.id.txtDateTime)

            //way 3 //best way to setup listener to view inside a RV
            itemView.setOnClickListener {

                if(onMessageClickListener != null) {
                    onMessageClickListener!!.onMessageClick(
                        adapterPosition,
                        messages[adapterPosition],
                        it
                    )
                }

                /*Toast.makeText(
                    it.context,
                    "Message from: ${messages[adapterPosition].sender}",
                    Toast.LENGTH_SHORT
                ).show()*/
            }
        }
    }

    override fun getItemCount() = messages.size

    //we have no idea for what position the view will be used
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.message_view, null)

        //way 1 //not useful
        /*view.setOnClickListener {
            Toast.makeText(it.context, "Message clicked", Toast.LENGTH_SHORT).show()
        }*/

        return MessageViewHolder(view)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        holder.imgSender.setImageResource(messages[position].senderImageId)
        holder.txtSender.text = messages[position].sender
        holder.txtBody.text = messages[position].body
        holder.txtDateTime.text = messages[position].dateTime

        //when we set up the listener to the view inside the vh in onBind method
        //we get the VH/view + position for the item
        //way 2 //better than way 1 however costs more in terms of cpu usage
        /*holder.itemView.setOnClickListener {
            Toast.makeText(
                it.context,
                "Message from: ${messages[position].sender} clicked",
                Toast.LENGTH_SHORT
            ).show()
        }*/
    }


}