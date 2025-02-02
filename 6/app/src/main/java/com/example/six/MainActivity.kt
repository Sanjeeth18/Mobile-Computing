package com.example.six

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val firstName = findViewById<EditText>(R.id.etFirstName)
        val lastName = findViewById<EditText>(R.id.etLastName)
        val phoneNumber = findViewById<EditText>(R.id.etPhone)
        val email = findViewById<EditText>(R.id.etEmail)
        val birthday = findViewById<EditText>(R.id.etBirthday)
        val gender = findViewById<EditText>(R.id.etGender)
        val address = findViewById<EditText>(R.id.etAddress)
        val btnSave = findViewById<Button>(R.id.btnSave)

        sharedPreferences = getSharedPreferences("UserDetails", MODE_PRIVATE)

        // Check if data is coming from PreviewActivity (for editing)
        val extras = intent.extras
        if (extras != null) {
            firstName.setText(extras.getString("FirstName", "") ?: "")
            lastName.setText(extras.getString("LastName", "") ?: "")
            phoneNumber.setText(extras.getString("Phone", "") ?: "")
            email.setText(extras.getString("Email", "") ?: "")
            birthday.setText(extras.getString("Birthday", "") ?: "")
            gender.setText(extras.getString("Gender", "") ?: "")
            address.setText(extras.getString("Address", "") ?: "")
        }

        firstName.requestFocus()  // Set focus to first name

        btnSave.setOnClickListener {
            if (validateInputs(firstName, lastName, phoneNumber, email, birthday, gender, address)) {
                // Save to SharedPreferences
                val editor = sharedPreferences.edit()
                editor.putString("FirstName", firstName.text.toString().trim())
                editor.putString("LastName", lastName.text.toString().trim())
                editor.putString("Phone", phoneNumber.text.toString().trim())
                editor.putString("Email", email.text.toString().trim())
                editor.putString("Birthday", birthday.text.toString().trim())
                editor.putString("Gender", gender.text.toString().trim())
                editor.putString("Address", address.text.toString().trim())
                editor.apply()

                // Navigate to PreviewActivity
                val intent = Intent(this, PreviewActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun validateInputs(
        firstName: EditText, lastName: EditText, phone: EditText,
        email: EditText, birthday: EditText, gender: EditText, address: EditText
    ): Boolean {
        // Helper function to check empty fields
        fun isEmptyField(editText: EditText, fieldName: String): Boolean {
            if (editText.text.isNullOrBlank()) { // Null & empty check
                Toast.makeText(this, "$fieldName is required", Toast.LENGTH_SHORT).show()
                return true
            }
            return false
        }

        // Check for empty fields
        if (isEmptyField(firstName, "First Name")) return false
        if (isEmptyField(lastName, "Last Name")) return false
        if (isEmptyField(phone, "Phone Number")) return false
        if (isEmptyField(email, "Email")) return false
        if (isEmptyField(birthday, "Birthday")) return false
        if (isEmptyField(gender, "Gender")) return false
        if (isEmptyField(address, "Address")) return false

        // Validate Email
        val emailText = email.text.toString().trim()
        if (!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
            Toast.makeText(this, "Enter a valid Email", Toast.LENGTH_SHORT).show()
            return false
        }

        // Validate Phone Number (must be 10 digits)
        val phoneText = phone.text.toString().trim()
        if (!phoneText.matches(Regex("^[0-9]{10}$"))) {
            Toast.makeText(this, "Enter a valid 10-digit Phone Number", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }
}
