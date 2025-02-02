package com.example.one

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Get references to UI elements
        val fahreninput = findViewById<EditText>(R.id.editTextNumber)
        val celsiusinput = findViewById<EditText>(R.id.editTextNumber2)
        val submit = findViewById<Button>(R.id.button)

        submit.setOnClickListener {
            val fahren = fahreninput.text.toString()
            val cel = celsiusinput.text.toString()

            if (fahren.isNotEmpty() && cel.isEmpty()) {
                // Convert Fahrenheit to Celsius
                val fahrenheit = fahren.toDouble()
                val celsius = (fahrenheit - 32) * 5 / 9

                // Show result in Toast
                Toast.makeText(this, "The Celsius temperature is %.2f°C".format(celsius), Toast.LENGTH_SHORT).show()

            } else if (cel.isNotEmpty() && fahren.isEmpty()) {
                // Convert Celsius to Fahrenheit
                val celsius = cel.toDouble()
                val fahrenheit = (celsius * 9 / 5) + 32

                // Show result in Toast
                Toast.makeText(this, "The Fahrenheit temperature is %.2f°F".format(fahrenheit), Toast.LENGTH_SHORT).show()

            } else if (cel.isNotEmpty() && fahren.isNotEmpty()) {
                // If both fields are filled, recalculate one based on the other
                val fahrenheit = fahren.toDouble()
                val celsius = cel.toDouble()
                val calculatedCelsius = (fahrenheit - 32) * 5 / 9
                val calculatedFahrenheit = (celsius * 9 / 5) + 32


                // Show results in Toast
                Toast.makeText(
                    this,
                    "Updated: %.2f°F → %.2f°C | %.2f°C → %.2f°F"
                        .format(fahrenheit, calculatedCelsius, celsius, calculatedFahrenheit),
                    Toast.LENGTH_SHORT
                ).show()            }
        }
    }
}
