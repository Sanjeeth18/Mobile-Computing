package com.example.six

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PreviewActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)

        val tvDetails = findViewById<TextView>(R.id.tvDetails)
        val btnConfirm = findViewById<Button>(R.id.btnConfirm)
        val btnEdit = findViewById<Button>(R.id.btnEdit)

        sharedPreferences = getSharedPreferences("UserDetails", MODE_PRIVATE)

        val firstName = sharedPreferences.getString("FirstName", "") ?: ""
        val lastName = sharedPreferences.getString("LastName", "") ?: ""
        val phone = sharedPreferences.getString("Phone", "") ?: ""
        val email = sharedPreferences.getString("Email", "") ?: ""
        val birthday = sharedPreferences.getString("Birthday", "") ?: ""
        val gender = sharedPreferences.getString("Gender", "") ?: ""
        val address = sharedPreferences.getString("Address", "") ?: ""

        val details = """
            Name: $firstName $lastName
            Phone: $phone
            Email: $email
            Birthday: $birthday
            Gender: $gender
            Address: $address
        """.trimIndent()

        tvDetails.text = details

        // Edit button - Send data back to MainActivity
        btnEdit.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("FirstName", firstName)
            intent.putExtra("LastName", lastName)
            intent.putExtra("Phone", phone)
            intent.putExtra("Email", email)
            intent.putExtra("Birthday", birthday)
            intent.putExtra("Gender", gender)
            intent.putExtra("Address", address)
            startActivity(intent)
        }

        // Confirm button - Go to ConfirmationActivity
        btnConfirm.setOnClickListener {
            val intent = Intent(this, ConfirmationActivity::class.java)
            intent.putExtra("FirstName", firstName)
            startActivity(intent)
        }
    }
}
