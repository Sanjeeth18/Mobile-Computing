package com.example.six

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ConfirmationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation)

        val tvMessage = findViewById<TextView>(R.id.tvMessage)
        val firstName = intent.getStringExtra("FirstName")

        tvMessage.text = "Hi $firstName, You are successfully registered!"
    }
}
