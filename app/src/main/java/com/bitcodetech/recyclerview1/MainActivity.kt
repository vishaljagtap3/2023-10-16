package com.bitcodetech.recyclerview1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerMessages: RecyclerView
    private lateinit var messagesAdapter: MessagesAdapter
    private val messages = ArrayList<Message>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        recyclerMessages = findViewById(R.id.recyclerMessages)

        initMessages()

        messagesAdapter = MessagesAdapter(messages)
        recyclerMessages.adapter = messagesAdapter

        recyclerMessages.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    }

    private fun initMessages() {
        for (i in 0..20) {
            messages.add(
                Message(
                    "Sender $i",
                    "$i - Dear student, you are not serious about the course.",
                    "2023-11-27",
                    R.mipmap.ic_launcher
                )
            )
        }
    }
}