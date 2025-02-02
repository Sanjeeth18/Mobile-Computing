package com.example.three

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val ratingBar = findViewById<RatingBar>(R.id.ratingBar)
        val feedbackText = findViewById<TextView>(R.id.textView2)
        val messageInput = findViewById<EditText>(R.id.editTextText)
        val sendButton = findViewById<Button>(R.id.button)

        ratingBar.stepSize = 1f

        var ratingMessage = ""

        ratingBar.setOnRatingBarChangeListener { _, rating, _ ->
            val ratingValue = rating.toInt()

            // Ensure the rating is within the valid range
            if (ratingValue in 1..5) {
                ratingMessage = when (ratingValue) {
                    5 -> "Awesome. I love it"
                    4 -> "Good. Enjoyed it"
                    3 -> "Satisfied."
                    2 -> "Not good. Need improvement"
                    1 -> "Disappointed. Very poor"
                    else -> ""  // This should never be reached due to the if check
                }
                feedbackText.text = ratingMessage
            } else {
                Toast.makeText(this, "Message should be within 1-5 rating!", Toast.LENGTH_SHORT).show()
            }
        }


        sendButton.setOnClickListener {
            val userMessage = messageInput.text.toString().trim()

            if (userMessage.isEmpty()) {
                Toast.makeText(this, "Message is required!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (userMessage.length > 100) {
                Toast.makeText(this, "Message should be within 100 characters!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val finalMessage = "Rating: $ratingMessage\nFeedback: $userMessage"
            Toast.makeText(this, finalMessage, Toast.LENGTH_LONG).show()
            messageInput.text.clear();
            ratingBar.rating=0f;
            feedbackText.text="We hope you enjoyed your meal with us today!!";
        }
    }
}
